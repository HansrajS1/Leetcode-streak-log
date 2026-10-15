class NumArray {
private:
    vector<int> tree;
    vector<int> numsRef;
    int n;


    void add(int i, int delta) {
        for (; i <= n; i += i & -i) {
            tree[i] += delta;
        }
    }


    int query(int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) {
            sum += tree[i];
        }
        return sum;
    }

public:
    NumArray(vector<int>& nums) {
        n = nums.size();
        numsRef = nums;
        tree.assign(n + 1, 0);
        for (int i = 0; i < n; ++i) {
            add(i + 1, nums[i]);
        }
    }
    
    void update(int index, int val) {
        int delta = val - numsRef[index];
        numsRef[index] = val;
        add(index + 1, delta);
    }
    
    int sumRange(int left, int right) {
        return query(right + 1) - query(left); 
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * obj->update(index,val);
 * int param_2 = obj->sumRange(left,right);
 */
