package linkedstructures;

public class App {

	public static void main(String[] args) {

		System.out.println("----------------------------- LinkedList -----------------------------");
		System.out.println();

		LinkedList<String> list = new LinkedList<>();
		list.insertFirst("item-1");
		list.insertLast("item-2");
		list.insertFirst("item-3");
		list.insertLast("item-4");

		System.out.println("initial list:");
		list.print();

		System.out.println();
		System.out.println("item at index 3 : " + list.get(3));
		System.out.println();

		list.insertBefore("item-5", "item-2");
		list.insertAfter("item-6", "item-3");

		System.out.println("items inserted, list:");
		list.print();

		System.out.println();
		System.out.println("-------------------------------- Stack --------------------------------");
		System.out.println();

		Stack<String> stack = new Stack<>();
		stack.push("item-1");
		stack.push("item-2");
		stack.push("item-3");
		stack.push("item-4");

		System.out.println("pop 1: " + stack.pop());
		System.out.println("pop 2: " + stack.pop());
		System.out.println("peek 1: " + stack.front());
		System.out.println("pop 3: " + stack.pop());
		System.out.println("pop 4: " + stack.pop());

		System.out.println();
		System.out.println("-------------------------------- Queue --------------------------------");
		System.out.println();

		Queue<String> queue = new Queue<>();
		queue.enqueue("item-1");
		queue.enqueue("item-2");
		queue.enqueue("item-3");
		queue.enqueue("item-4");
		queue.enqueue("item-5");

		System.out.println("queue size: " + queue.size());
		System.out.println("dequeue 1: " + queue.dequeue());
		System.out.println("dequeue 2: " + queue.dequeue());
		System.out.println("dequeue 3: " + queue.dequeue());
		System.out.println("peek 1: " + queue.front());
		System.out.println("dequeue 4: " + queue.dequeue());
		System.out.println("dequeue 5: " + queue.dequeue());
	}
}