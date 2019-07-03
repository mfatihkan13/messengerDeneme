package com.mfatih.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.mfatih.messenger.database.DatabaseClass;
import com.mfatih.messenger.exception.DataNotFoundException;
import com.mfatih.messenger.model.Comment;
import com.mfatih.messenger.model.Message;

public class MessageService {

	Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {

		messages.put(1L, new Message(1, "message1", "author1"));
		messages.put(2L, new Message(2, "message2", "author2"));
		messages.put(3L, new Message(3, "message3", "author3"));
		
		Message message1 = messages.get(1L);
		message1.getComments().put(1L, new Comment(1L, "firstComment", "author1"));
        message1.getComments().put(2L, new Comment(2L, "secondComment", "author2"));
//		messages.get(1).getComments().put(3L, new Comment(3L, "thirdComment", "author3"));
//		messages.get(1).getComments().put(4L, new Comment(4L, "Comment", "author2"));
//		messages.get(1).getComments().put(5L, new Comment(5L, "Comment", "author2"));
//		messages.get(1).getComments().put(6L, new Comment(6L, "Comment", "author2"));
		
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesForYear(int year) {

		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}

		}

		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) {
			return new ArrayList<>();
		}
		return list.subList(start, start + size);

	}

	public Message getMessage(long messageId) {
		Message message = messages.get(messageId);
		if (message == null) {
			throw new DataNotFoundException("Message with id " + messageId + " not found");
		}
		return message;
	}

	public Message addMessage(Message m) {
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}

	public Message updateMessage(Message m) {
		if (m.getId() <= 0) {
			return null;
		}

		messages.put(m.getId(), m);
		return m;

	}

	public Message deleteMessage(long messageId) {
		return messages.remove(messageId);
	}

}
