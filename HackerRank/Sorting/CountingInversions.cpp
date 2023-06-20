#include <iostream>
#include <vector>

using namespace std;

long long merge(vector<int>& arr, vector<int>& temp, int left, int mid, int right) {
    long long inversions = 0;
    int i = left, j = mid + 1, k = left;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inversions += mid - i + 1;
        }
    }

    while (i <= mid) temp[k++] = arr[i++];
    
    while (j <= right) temp[k++] = arr[j++];

    for (i = left; i <= right; i++) arr[i] = temp[i];

    return inversions;
}

long long mergeSort(vector<int>& arr, vector<int>& temp, int left, int right) {
    long long inversions = 0;

    if (left < right) {
        int mid = left + (right - left) / 2;

        inversions += mergeSort(arr, temp, left, mid);
        inversions += mergeSort(arr, temp, mid + 1, right);
        inversions += merge(arr, temp, left, mid, right);
    }

    return inversions;
}

long long countInversions(vector<int>& arr) {
    int n = arr.size();
    vector<int> temp(n);

    return mergeSort(arr, temp, 0, n - 1);
}