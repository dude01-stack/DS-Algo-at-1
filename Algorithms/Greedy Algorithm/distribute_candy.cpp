// Link: https://www.interviewbit.com/problems/distribute-candy/

int Solution::candy(vector<int> &A) {
    int N = A.size();
    vector<int> left(N, 1); // all elements have 1(satisfy condt 1)
    for(int i = 1; i<N; i++){
        // if a rating is more than rating on its left, inc candy of said rating
        // by 1 more than no. of candy on left
        if(A[i] > A[i-1]) left[i] = left[i-1]+1;
    }
    vector<int> right(N,1);
    for(int i = N-2; i>=0; i--){
        // if a rating is more than rating on its right, inc candy of said rating
        // by 1 more than no. of candy on right
        if(A[i] > A[i+1]) right[i] = right[i+1]+1;
    }
    int total = 0;
    for(int i = 0; i<N; i++){
        // max of left2right and right2left candies will satisy condt 2(more candy than
        // both neighbours if higher rating)
        total += max(left[i], right[i]);
    }
    return total;
}
