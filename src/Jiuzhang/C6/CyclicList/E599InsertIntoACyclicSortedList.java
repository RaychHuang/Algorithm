package Jiuzhang.C6.CyclicList;

import Jiuzhang.C6.LinkedList.ListNode;

public class E599InsertIntoACyclicSortedList {
	
    public ListNode insert(ListNode node, int x) {
        // write your code here
        ListNode newNode = new ListNode(x);
        ListNode head = node;
        ListNode nextNode;
        if(node == null){
            nextNode = newNode;
        }else{
            do{
            	if(node.val <= x && x <= node.next.val){
            		break;
            	}
            	if(node.val > node.next.val && x >= node.val){
            		break;
            	}
            	if(node.val > node.next.val && x <= node.next.val){
            		break;
            	}
            	node = node.next;
            }while(node != head);
            nextNode = node.next;
            node.next = newNode;
        }

            // while((node.val < node.next.val && (x > node.next.val || x < node.val))){
            //     node = node.next;
            // }
        newNode.next = nextNode;
        return newNode;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
