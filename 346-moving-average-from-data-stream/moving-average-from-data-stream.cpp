class MovingAverage {
private:
    int size, windowSum = 0, count = 0;
    std::deque<int> queue;

public:
    MovingAverage(int size) { this->size = size; }

    double next(int val) {
        ++count;
        // calculate the new sum by shifting the window
        queue.push_back(val);
        int tail = count > size ? queue.front() : 0;
        if (count > size) queue.pop_front();

        windowSum = windowSum - tail + val;

        return static_cast<double>(windowSum) / std::min(size, count);
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage* obj = new MovingAverage(size);
 * double param_1 = obj->next(val);
 */