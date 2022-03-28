#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

using namespace std;

#define instance_node (struct node *) malloc(sizeof(struct node))

struct node {
    struct node *left;
    int data;
    struct node *right;
};

void preorder_print(struct node *currentNode); 
void inorder_print(struct node *currentNode);
void posorder_print(struct node *currentNode);
void insert(struct node *&currentNode, int number);
void simple_print(struct node *currentNode);
void search_data(struct node *currentNode, int data);

void preorder_print(struct node *currentNode) {
    if (currentNode != NULL) {
        simple_print(currentNode);
        preorder_print(currentNode -> left);
        preorder_print(currentNode -> right);
    }
}

void inorder_print(struct node *currentNode) {
    if (currentNode != NULL) {
        inorder_print(currentNode -> left);
        simple_print(currentNode);
        inorder_print(currentNode -> right);
        
    }
}

void posorder_print(struct node *currentNode) {
    if (currentNode != NULL) {
        posorder_print(currentNode -> left);
        posorder_print(currentNode -> right);
        simple_print(currentNode);
    }
}

void simple_print(struct node *currentNode) {
    cout << "El dato en la posicion " << " es: " << currentNode -> data << "\n";
}

void search_data(struct node *currentNode, int data) {

    if (currentNode == NULL) {
        cout << "DATO NO ENCONTRADO EN EL ARBOL\n";
        return;
    }

    if (data == currentNode -> data) {
        cout << "DATO " << currentNode -> data << " ENCONTRADO \n";
        return;
    }

    if (data < currentNode->data) {
        search_data(currentNode -> left, data);
    } else {
        search_data(currentNode -> right, data);
    }

}

int node_lenght(struct node *currentNode, int i) {
    if (currentNode != NULL) {
        node_lenght(currentNode -> left, i);
        node_lenght(currentNode -> right, i);
        i++;
    }
    return i;
}

void insert(struct node *&currentNode, int number) {
    struct node *viewNode;

    viewNode = currentNode;

    if (currentNode == NULL) {
        viewNode = instance_node;
        currentNode = viewNode;
        viewNode -> data = number;
        viewNode -> left = NULL;
        viewNode -> right = NULL;
    } else {
        if (number > viewNode -> data) {
            insert(currentNode -> right, number);
        } else {
            insert(currentNode -> left, number);
        }
    }
}

int main() {
    int opc = 0;
    struct node *currentNode = NULL;


    while (opc != 4) {
        cout << "Eliga la opcion requerida\n"
            << "1. Insertar datos\n"
            << "2. Recorrer arbol\n"
            << "3. Buscar\n"
            << "4. Salir\n"
            << "Escriba la opcion que requiera: \t";
        cin >> opc;

        switch (opc) {
            case 1:
                int number;
                cout << "Ingrese el dato que desee poner en el arbol:\t";
                cin >> number;
                insert(currentNode, number);
                fflush(stdin);
                cout << "|*|--------------------[ PREORDEN ]--------------------|*|\n";
                preorder_print(currentNode);
                cout << "|*|--------------------[ INORDEN ]--------------------|*|\n";
                inorder_print(currentNode);
                cout << "|*|--------------------[ POSTORDEN ]--------------------|*|\n";
                posorder_print(currentNode);
                break;
            case 2:
                cout << "|*|--------------------[ PREORDEN ]--------------------|*|\n";
                preorder_print(currentNode);
                cout << "|*|--------------------[ INORDEN ]--------------------|*|\n";
                inorder_print(currentNode);
                cout << "|*|--------------------[ POSTORDEN ]--------------------|*|\n";
                posorder_print(currentNode);
                break;
            case 3:
                int data;
                cout << "Ingrese el dato a buscar en el arbol:\t";
                cin >> data;
                search_data(currentNode, data);
                cout << "TAMANO DE LA LISTA: " << node_lenght(currentNode, 0) << "\n";
                fflush(stdin);
                break;
            case 4:
                continue;
            default:
                cout << "Dato incorrecto, por favor verifique que este corresponda al menu\n";
                break;
        }
    }
    return 0;
}