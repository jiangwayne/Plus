package com.plus.server.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.dal.CommentDAO;
import com.plus.server.dal.OrderDAO;
import com.plus.server.dal.ProductDAO;
import com.plus.server.dal.ProductSpecDAO;
import com.plus.server.model.Comment;
import com.plus.server.model.Order;
import com.plus.server.model.Product;

@Service
public class CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentService.class);
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ProductSpecDAO productSpecDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CommentDAO commentDAO;

	/**
	 * 评论订单
	 * 
	 * @param userId
	 * @param orderId
	 * @param content
	 */
	@Transactional(rollbackFor = Exception.class)
	public void saveComment(Long userId, Long orderId, String content) throws Exception {
		log.info("评论订单，userId={}，orderId={}，content={}", userId, orderId, content);
		if (userId == null || orderId == null || content == null) {
			throw new Exception("参数不能为空");
		}
		Order order = orderDAO.selectByPrimaryKey(orderId);
		if (order == null) {
			throw new Exception("订单不存在");
		}
		if (order.getStatus() != 30) {
			throw new Exception("订单状态不正确");
		}
		Product pro = productDAO.selectByPrimaryKey(order.getProductId());
		if (pro == null) {
			throw new Exception("产品不存在");
		}
		// 插入评论
		Comment co = new Comment();
		co.setContent(content);
		co.setOrderId(orderId);
		co.setProductId(order.getProductId());
		co.setGmtCreate(new Date());
		co.setUserId(userId);
		co.setValid(1);
		co.setStatus(10);// 状态（10-待审核，20-已审核）
		commentDAO.insert(co);
		// 修改 产品的评论数
		Product proParam = new Product();
		proParam.setId(pro.getId());
		proParam.setCommentCount(proParam.getCommentCount()==null?1:(proParam.getCommentCount()+ 1));
		productDAO.updateCommentCountSaleCountByPrimaryKey(proParam);
		// 修改订单状态为已评论
		Order oParam = new Order();
		oParam.setId(orderId);
		oParam.setStatus(40);//状态（10-待确认，20-待付款，30-待评价，40-已评价，50-已取消）
		orderDAO.updateByPrimaryKeySelective(oParam);
	}

	/**
	 * 修改评论状态
	 * 
	 * @param userId
	 * @param orderId
	 * @param content
	 */
	public void updateComment(Long userId, Comment comment) throws Exception {
		log.info("修改评论状态，userId={}，comment={}", userId, JSON.toJSONString(comment));
		this.commentDAO.updateByPrimaryKeySelective(comment);
	}

	/**
	 * 查询评论
	 * 
	 * @param comment
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Comment> selectByModel(Comment comment, int page, int pageSize) {
		log.info("订单查询，comment={},page={},pageSize={}", JSON.toJSONString(comment), page, pageSize);
		if (page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		PageHelper.startPage(page, pageSize);
		List<Comment> list = commentDAO.selectByModel(comment);
		PageInfo<Comment> pageInfo = new PageInfo<Comment>(list);
		return pageInfo;
	}
}
