package com.plus.server.common.vo.resp;

import java.util.List;

import com.plus.server.common.vo.CommentVo;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class CommentListResp extends BasePageResp {

	@ApiModelProperty("评论列表")
	private List<CommentVo> commentList;

	public List<CommentVo> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<CommentVo> commentList) {
		this.commentList = commentList;
	}

}
