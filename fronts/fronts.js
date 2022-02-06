class Node{
    constructor(data){
        this.data=data;
        this.next=null;
    }
}
class LinkedList{
    constructor(){
        this.head=null;
    }
    addFront(val){
        let new_node =new Node(val);
        if(!this.head){
            this.head=new_node;
            return this;
        }
        new_node.next=this.head;
        this.head=new_node;
        return this;
    }
    removeFront() {
        if(!this.head){
            return this.head;
        }
        let removeNode = this.head;
        this.head = removeNode.next;
        removeNode.next=null;
        return this;
    }
    front(){
        if (!this.head){
            return null;
        } else{
            return this.head.val;
        }
    }
}
let LinkedList = new LinkedList();
LinkedList.addFront(20);