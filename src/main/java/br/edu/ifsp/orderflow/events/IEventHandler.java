package br.edu.ifsp.orderflow.events;

/*algo que irá consumir/reagir atipo especifico de evento (uma classe
* que implementa IDomainEvent*/

public interface IEventHandler<E extends IDomainEvent> {

    void handle(E event);

    Class<E> eventType();

}
