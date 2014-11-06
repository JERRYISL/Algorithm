package algorithm;

/**
 * 单链表构造（两种方式）
 * @author lujiabin
 * @since 2014-11-6
 */
public class SingleLinkedList {
	//节点类
	public class LinkNode{
		public int data;
		public LinkNode next;
		
		public LinkNode(int data){
			this.data = data;
		}
	}
	
	private LinkNode head;//头结点
	
	//递归构造
	public void recursiveAdd(int data){
		if(head == null){
			head = new LinkNode(data);
		}else{
			add(head,data);
		}
	}
	
	public void add(LinkNode node,int data){
		if(node.next == null){
			node.next = new LinkNode(data);
			return;
		}else{
			add(node.next, data);
		}
	}
	
	//非递归构造
	public void nonRecursiveAdd(int data){
		LinkNode node = new LinkNode(data);
		if(head == null){
			head = node;
		}else{
			LinkNode tmpNode = head;
			while(tmpNode.next != null){
				tmpNode = tmpNode.next;
			}
			tmpNode.next = node;
		}
	}
}
