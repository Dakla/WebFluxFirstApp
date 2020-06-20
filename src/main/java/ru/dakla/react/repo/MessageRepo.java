package ru.dakla.react.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import ru.dakla.react.domain.Message;

public interface MessageRepo extends ReactiveCrudRepository<Message, Long> {
}
