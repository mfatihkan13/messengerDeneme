package com.mfatih.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mfatih.messenger.database.DatabaseClass;
import com.mfatih.messenger.model.Comment;
import com.mfatih.messenger.model.Message;

public class CommentService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	

	public CommentService() {
		
	}
	

	public List<Comment> getAllComments(long messageId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<>(comments.values());
		
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
		
	}
	
	public Comment addComment(long messageId, Comment newComment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		newComment.setId(comments.size() + 1);
		comments.put(newComment.getId(), newComment);
		return newComment;
	}
	
	public Comment updateCommnet(long messageId, Comment updatedComment) {
		if(updatedComment.getId() <= 0) {
			return null;
		}
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(updatedComment.getId(), updatedComment);
		return updatedComment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
		
	}

}
