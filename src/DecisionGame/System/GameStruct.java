package DecisionGame.System;

import java.util.Random;

class GameStruct implements GameGenerator {
    GameObject Start = null, Point = null, Left = null, Right = null;
    
    public void Sign(String n, int v){
        Knight temp = new Knight(n, v);
        this.Start = temp;
    }

    public void addOp(String s){   
        int val_r = numgen();
        int val_l = numgen();
        char op_r = opgen();
        char op_l = opgen();
        Right = new Equipment(op_r, val_r);
        Left = new Equipment(op_l, val_l);
        GameObject Start = getNode(s);
        Start.leftNode = Left;
        Start.rightNode = Right;
    }

    public GameObject getNode(String name){
        findNode(this.Start, name);
        GameObject hasil = this.Point;
        this.Point = null;
        return hasil;
    }

    public void findNode(GameObject setar, String name){
        if(setar == null){
            return;
        }
        if(setar.name.equalsIgnoreCase(name)){
            this.Point = setar; return;
        }
        findNode(setar.leftNode, name);
        findNode(setar.rightNode, name);
    }

    @Override
    public char opgen() {
        Random random = new Random();
        int Range = 0;
        char[] op = {'-','+','*','+','-','/','*','+','/','*'};
        while (true){ if(Range != -1) break; }
        Range = random.nextInt(10);
        if(Range == 0) return op[Range];
        else if(Range == 1) return op[Range];
        else if(Range == 2) return op[Range];
        else if(Range == 3) return op[Range];
        else if(Range == 4) return op[Range];
        else if(Range == 5) return op[Range];
        else if(Range == 6) return op[Range];
        else if(Range == 7) return op[Range];
        else if(Range == 8) return op[Range];
        else return op[Range];
    }

    @Override
    public int numgen() {
        Random random = new Random();
        int Range = 0;
        while (true){ if(Range != -1) break; }
        Range = random.nextInt(2,10);
        return Range;
    }

    void Start(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
