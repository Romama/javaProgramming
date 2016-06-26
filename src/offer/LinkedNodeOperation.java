package offer;

import java.awt.List;

/**
 * 链表操作：建立单链表、按值插入一个新结点、按值删除一个新结点、按结点指针删除（O(1)）结点
 * @author Administrator
 *
 */
public class LinkedNodeOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode();
		head.value = 1;
		ListNode p = head;
		
		//建立单链表 O(n)的空间复杂度，O(n)的时间复杂度
		for(int i = 0; i < 5; i++){
			ListNode node = new ListNode();
			node.value = i + 2;
			p.next = node;
			p = p.next;
		}
		p.next = null;
		
	}
	
	/**
	 * 从单链表中删除值为value的结点 。O(n)
	 * @param head
	 * @param value
	 * @return
	 */
	public static ListNode deleteNode(ListNode head,int value){
		if(head == null)
			return head;
		//若要删除的结点是第一个
		if(head.value == value){
			return head.next;
		} else {
			ListNode p = head;
			while(p.next != null && p.next.value != value){
				p = p.next;
			}
			
			if(p.next != null && p.next.value == value){
				p.next = p.next.next;      //删除结点
			}
			
			return head;
		}
	}
	
	/**
	 * 在单链表的末尾添加一个值为value的结点。O(n)
	 * @param head
	 * @param value
	 * @return
	 */
	public static ListNode addOneNode(ListNode head,int value){
		ListNode node = new ListNode();
		node.value = value;
		node.next = null;
		if(head == null)
			head = node;
		else {
			ListNode p = head;
			while(p.next != null){
				p = p.next;
			}
			p.next = node;
		}
		
		return head;
	}
	/**
	 * 在O(1)的时间内删除一个结点
	 * [(n-1) * O(1) + O(n)] / n = O(1)
	 * 这个前提是deleteNode在链表中
	 * 若要判断deleteNode是否在链表中，则需要O(n)的时间复杂度
	 */
	public static ListNode deleteOneNode(ListNode head,ListNode deleteNode){
		if(head == null)
			return head;
		if(deleteNode.next != null){//要删除的结点不是尾结点
			ListNode next = deleteNode.next;
			deleteNode.value = next.value;
			deleteNode.next = next.next;
		} else if(deleteNode == head){//链表中只有一个结点，且这个结点是头结点
			head = null;
		} else {//要删除的结点是尾结点
			ListNode p = head;
			while(p.next != null){
				p = p.next;
			}
			
			p.next = null; //删除尾结点
		}
		return head;
	}

}
