package adapter.messaging;

import domain.service.DomainEvent;

public interface IMessageQueue {

	public boolean send(DomainEvent domainEvent);
}
