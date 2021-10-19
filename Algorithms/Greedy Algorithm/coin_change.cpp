// Link: https://www.geeksforgeeks.org/greedy-algorithm-to-find-minimum-number-of-coins/

#include <iostream>

void coin_change_greedy(int n) {
  int coins[] = {20, 10, 5, 1};
  int i=0;

  while(n) {
    if(coins[i] > n) {
      i++;
    }
    else {
      printf("%d\t",coins[i]);
      n = n-coins[i];
    }
  }
  printf("\n");
}

int main() {
  int i;
  for(i=1; i<=20; i++) {
    coin_change_greedy(i);
  }
  return 0;
}
