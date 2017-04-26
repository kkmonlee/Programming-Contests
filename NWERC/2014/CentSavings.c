#include <stdio.h>

#define SIZE 2000
#define SIZE2 20
#define INF 2000000000

int prices[SIZE];
int accum[SIZE + 1];
int dp[SIZE + 1][SIZE + 1][SIZE2 + 1];

#define MIN(a,b) (a) < (b) ? (a) : (b)
#define ROUND(a) (a + 5) / 10 * 10


int main() {
  int N, D, i, j, k, ret;
  scanf("%d %d", &N, &D);

  for (i = 0; i < N; i++) {
    scanf("%d", &prices[i]);
  }

  for (i = 0; i <= N; i++) {
    for (j = 0; j <= N; j++) {
      for (k = 0; k <= D; k++) {
        dp[i][j][k] = INF;
      }
    }
  }

  accum[0] = 0;
  for (i = 0; i < N; i++) {
    accum[i + 1] = accum[i] + prices[i];
  }

  dp[0][0][0] = 0;
  for (i = 0; i < N; i++) {
    for (j = 0; j <= i; j++) {
      for (k = 0; k <= D; k++) {
        dp[i + 1][j][k] = MIN(dp[i + 1][j][k], dp[i][j][k]);

        if (k < D) {
          dp[i + 1][i][k + 1] = MIN(dp[i + 1][i][k + 1], dp[i][j][k] + ROUND(accum[i] - accum[j]));
        }
      }
    }
  }

  ret = INF;
  for (i = 0; i < N; i++) {
    for (j = 0; j <= D; j++) {
      ret = MIN(ret, dp[N][i][j] + ROUND(accum[N] - accum[i]));
    }
  }

  printf("%d\n", ret);

  return 0;
} 
