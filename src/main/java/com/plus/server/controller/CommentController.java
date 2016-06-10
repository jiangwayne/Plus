package com.plus.server.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.plus.server.common.PageDefault;
import com.plus.server.common.util.BeanMapper;
import com.plus.server.common.vo.CommentVo;
import com.plus.server.common.vo.resp.BaseResp;
import com.plus.server.common.vo.resp.CommentListResp;
import com.plus.server.model.Comment;
import com.plus.server.service.CommentService;
import com.plus.server.service.OrderService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@Api("评论")
@RequestMapping(value = "plus/comment")
public class CommentController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/saveComment", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "评论订单")
	public BaseResp saveComment(
			@ApiParam(required = true, value = "订单id") @RequestParam(required = true) Long orderId,
			@ApiParam(required = true, value = "评论内容") @RequestParam(required = true) String content) {
		log.info("评论订单---orderId={},content={}", orderId, content);
		BaseResp r = new BaseResp();
		Long userId = this.getCurrentUser().getId();
		try {
			commentService.saveComment(userId, orderId, content);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/updateCommentStatus", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改评论状态")
	public BaseResp updateCommentStatus(
			@ApiParam(required = true, value = "评论id") @RequestParam(required = true) Long id,
			@ApiParam(required = true, value = "状态（10-待审核，20-已审核）") @RequestParam(required = true) Integer status) {
		log.info("修改评论状态---id={},status={}", id, status);
		BaseResp r = new BaseResp();
		Long userId = this.getCurrentUser().getId();
		Comment comment = new Comment();
		comment.setId(id);
		comment.setStatus(status);
		try {
			commentService.updateComment(userId,comment);
		} catch (Exception e) {
			log.error("", e);
			r.setMsg(e.getMessage());
			return r;
		}
		r.setSuccess(true);
		return r;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "评论查询")
	public CommentListResp list(@ApiParam(required = false, value = "产品id") @RequestParam(required = false) Long productId,
			@ApiParam(required = false, value = "订单id") @RequestParam(required = false) Long orderId,
			@ApiParam(required = false, value = "状态（10-待审核，20-已审核）") @RequestParam(required = false) Integer status,
			@RequestParam(required = false) @ApiParam(required = false, value = "当前页码") Integer page,
			@RequestParam(required = false) @ApiParam(required = false, value = "每页记录数") Integer pageSize) {
		log.info("订单查询---productId={},status={}", productId, status);
		CommentListResp r = new CommentListResp();
		r.setSuccess(true);
		if (page == null || page <= 0) {
			page = PageDefault.PAGE_NUM_DEFAULT;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = PageDefault.PAGE_SIZE_DEFAULT;
		}
		Comment comment = new Comment();
		comment.setValid(1);
		comment.setOrderId(orderId);
		comment.setProductId(productId);
		comment.setStatus(status);
		PageInfo<Comment> pageInfo = commentService.selectByModel(comment, page, pageSize);
		List<CommentVo> list = BeanMapper.mapList(pageInfo.getList(), CommentVo.class);
		SimpleDateFormat f = new SimpleDateFormat();
		for(CommentVo vo : list){
			if(vo.getGmtCreate() != null){
				vo.setGmtCreateStr(f.format(vo.getGmtCreate()));
			}
		}
		r.setCommentList(list);
		r.setSuccess(true);
		return r;
	}
}
