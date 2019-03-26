#include <stdio.h>

struct node {
  int data;
  struct node *left;
  struct node *right;
};
typedef struct node Tree;

Tree *root = NULL;

Tree * add(Tree* nod, int number) {
    if (nod == NULL) {
        nod = (Tree*) malloc(sizeof (Tree));
        if (nod == NULL) {
            return NULL;
        }
        nod->info.num = number;
        nod->left = NULL;
        nod->right = NULL;
        return nod;
    }
    if (nod->info.num > number) {
        nod->left = add(nod->left, number);
    } else {
        nod->right = add(nod->right, number);
    }
    return nod;
}

Tree * find(Tree * nod, int val) {
    if (nod == NULL) {
        return NULL;
    }
    if (nod->info.num == val) {
        return nod;
    }
    if (nod->info.num > val) {
        return find(nod->left, val);
    }
    return find(nod->right, val);
}

void freeTree(Tree *root) {
    if (root == NULL) {
        return;
    }
    freeTree(root->left);
    freeTree(root->right);
    free(root);
}
