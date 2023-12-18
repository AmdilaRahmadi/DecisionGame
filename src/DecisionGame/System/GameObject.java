package DecisionGame.System;

public abstract class GameObject {
    int value;
    String name;
    GameObject leftNode, rightNode;
    char ope;
    
    GameObject(String name, int value ){
        this.name = name;
        this.value = value;
    }

    GameObject(char o, int value){
        this.ope = o;
        this.value = value;
    }
}
