class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.nextElement = iterator.next();
    }

    // Returns the next element without advancing.
    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {
        Integer result = nextElement;

        if (iterator.hasNext()) {
            nextElement = iterator.next();
        } else {
            nextElement = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}

