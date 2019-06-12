public class DLS {

    
    private DNode h=new DNode("0") ;
    public int size;
    
    public DLS() {              
        h.next = h;
        h.prev = h;
        size = 0;
    }

    public DNode next_previous = h;
    
    public boolean isEmpty() {
        return h.next == h && h.prev == h;
    }

   
    public String report(char x) {
        String data = "";
        if (isEmpty()) {
            data = " There are no words . ";
        } 
        else {
            DNode k = h.next;
            while (k != h) {
                data += k.data + " , ";
                k=k.next;
            }
        }
        return data;
    }

    
    public String getFirst(){
        if (isEmpty()) {
            return null;
        }
        String data = h.next.data;
        return data;

    }
    public String getNext(){
        if (isEmpty()) {
            return null;
        }
        next_previous = next_previous.next;
        return next_previous.data;
    }
    
    public String getPrevious(){
        if (isEmpty()) {
            return null;
        }
        next_previous = next_previous.prev;
        return next_previous.data;
    }
    
    public void addFirst(String e) {
        DNode z = new DNode(e);
        if (isEmpty()) {
            h.next = z;
            h.prev = z;
            z.next = h;
            z.prev = h;
            size++;
        } else {
            DNode k = h.next;
            z.next = h.next;
            z.prev = h;
            h.next = z;
            k.prev = z;
            size++;
        }
    }
    
    
    public boolean sortLinked(String x){
        if(isEmpty()){
            addFirst(x);
            return true;
        }
        else if(find(x)){
            return false;
        }
        else{
            int wordOrder = sortingProcess(x);
            DNode k = h.next;
            for(int i=1;i<wordOrder;i++){
                k=k.next;
            }
            DNode p = k.prev;
            DNode z = new DNode(x);
            z.next = k;
            z.prev = p;
            k.prev = z;
            p.next = z;
            size ++;
            return true;
        }
    }
    
    public boolean find(String x){
            DNode k = h.next;
            while (k != h) {
                if (k.data.equals(x)) {
                    return true;
                }
                k = k.next;
            }
        return false;
    }
    
    
    public boolean remove (String x){
        boolean ok = false;
        if(isEmpty()){
            return false;
        }
        else {
            DNode k = h.next;
            while (k != h) {
                if (k.data.equals(x)) {
                    DNode ka = k.prev;
                    DNode kb = k.next;
                    ka.next = kb;
                    kb.prev = ka;
                    size--;
                    ok = true;
                }
                k = k.next;
            }
            return ok;
        }
    }
    
    public int sortingProcess(String x){
        int posWord = 1;
        int lenE = x.length();
        char[] arr1 = new char[lenE];
        for (int i = 0; i < lenE; i++) {
            arr1[i] = x.charAt(i);
        }
        
        DNode k = h.next;
        while (k != h) {
            int lenK = k.data.length();
            char[] arr2 = new char[lenK];
            for (int i = 0; i < lenK; i++) {
                arr2[i] = k.data.charAt(i);
            }
            if(lenE >= lenK){
                int equals = lenK;
                for(int i=1;i<lenK;i++){
                    
                    int weightE = characterWeight(arr1[i]);
                    int weightK = characterWeight(arr2[i]);
                   
                    if (weightE > weightK){
                        posWord ++;
                        break;   
                    }
                    else if (weightE == weightK){
                        equals--;
                        if(equals == 1){
                            posWord++;
                        }
                       continue;   
                    }
                    else{
                        return posWord;
                    } 
                }
                k=k.next;
            }
            else{
                int equals = lenE;
                for(int i=1;i<lenE;i++){
                    int weightE = characterWeight(arr1[i]);
                    int weightK = characterWeight(arr2[i]);
                    if (weightE>weightK){
                        posWord ++;
                        break;    
                    }
                    else if (weightE==weightK){
                        equals--;
                        if(equals == 1){
                            return posWord;
                        }
                        continue;    
                    }
                    else{
                        return posWord;
                    }
                }
                k=k.next;
            }
        }
        return posWord;
    }
    
    public int characterWeight(char x){
        if(x=='A'||x=='a'){
            return 0;
        }
        else if(x=='B'||x=='b'){
            return 1;
        }
        else if(x=='C'||x=='c'){
            return 2;
        }
        else if(x=='D'||x=='d'){
            return 3;
        }
        else if(x=='E'||x=='e'){
            return 4;
        }
        else if(x=='F'||x=='f'){
            return 5;
        }
        else if(x=='G'||x=='g'){
            return 6;
        }
        else if(x=='H'||x=='h'){
            return 7;
        }
        else if(x=='I'||x=='i'){
            return 8;
        }
        else if(x=='J'||x=='j'){
            return 9;
        }
        else if(x=='K'||x=='k'){
            return 10;
        }
        else if(x=='L'||x=='l'){
            return 11;
        }
        else if(x=='M'||x=='m'){
            return 12;
        }
        else if(x=='N'||x=='n'){
            return 13;
        }
        else if(x=='O'||x=='o'){
            return 14;
        }
        else if(x=='P'||x=='p'){
            return 15;
        }
        else if(x=='Q'||x=='q'){
            return 16;
        }
        else if(x=='R'||x=='r'){
            return 17;
        }
        else if(x=='S'||x=='s'){
            return 18;
        }
        else if(x=='T'||x=='t'){
            return 19;
        }
        else if(x=='U'||x=='u'){
            return 20;
        }
        else if(x=='V'||x=='v'){
            return 21;
        }
        else if(x=='W'||x=='w'){
            return 22;
        }
        else if(x=='X'||x=='x'){
            return 23;
        }
        else if(x=='Y'||x=='y'){
            return 24;
        }
        else if(x=='Z'||x=='z'){
            return 25;
        }
        return -1;
    }  
}
