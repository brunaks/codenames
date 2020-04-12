package bmworks.endpoints;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator implements IdGenerator {
    @Override
    public String next() {
        return UUID.randomUUID().toString();
    }
}
