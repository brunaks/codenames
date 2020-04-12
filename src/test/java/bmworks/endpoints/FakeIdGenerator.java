package bmworks.endpoints;

class FakeIdGenerator implements IdGenerator {
    private int number = 1;

    @Override
    public String next() {
        return String.format("id%d", number++);
    }
}
