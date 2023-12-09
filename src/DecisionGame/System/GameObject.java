package DecisionGame.System;

public abstract class GameObject {
    int value, level, reset_number;
    String name;
    GameObject leftNode, rightNode, nextNode, prevNode;
    char ope;
    
    GameObject(String name, int value ){
        this.name = name;
        this.value = value;
    }

    GameObject(char o, int value){
        this.ope = o;
        this.value = value;
    }

    GameObject(String name, int value, int lvl, int rn){
        this.name = name;
        this.value = value;
        this.level = lvl;
        this.reset_number = rn;
    }
}
