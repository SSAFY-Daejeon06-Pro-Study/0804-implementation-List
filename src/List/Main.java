package day0830;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList();

        System.out.println("[add] 1, 2, 3 원소 추가");
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();

        System.out.println("[add] 두 번째에 4 원소 중간 삽입");
        list.add(1, 4);
        list.print();

        System.out.println("[remove] 세 번째 2 원소 삭제");
        list.remove(2);
        list.print();

        System.out.println("[get] 마지막 원소 검색");
        System.out.println("--------");
        System.out.println(list.get(list.size()-1));
        System.out.println("--------");
        System.out.println();

        System.out.println("[get] 두 번째 원소 검색");
        System.out.println("--------");
        System.out.println(list.get(1));
        System.out.println("--------");
        System.out.println();

        System.out.println("[add] 첫 번째에 5 원소 삽입");
        list.add(0, 5);
        list.print();

        System.out.println("[indexOf] 원소 4 위치 검색");
        System.out.println("--------");
        System.out.println(list.indexOf(4));
        System.out.println("--------");
        System.out.println();

        System.out.println("[remove] 마지막 삭제");
        list.remove(list.size()-1);
        list.print();

        System.out.println("[add] 원소 8 두 번째에 삽입");
        list.add(1, 8);
        list.print();

        System.out.println("[contains] 원소 8을 포함하고 있나?");
        System.out.println("--------");
        System.out.println(list.contains(8));
        System.out.println("--------");
        System.out.println();

        System.out.println("[set] 두 번째 원소 8을 6으로 바꾸기");
        list.set(1, 6);
        list.print();

        System.out.println("[contains] 원소 8을 포함하고 있나?");
        System.out.println("--------");
        System.out.println(list.contains(8));
        System.out.println("--------");
        System.out.println();

        System.out.println("[isEmpty] 비어있나?");
        System.out.println("--------");
        System.out.println(list.isEmpty());
        System.out.println("--------");
        System.out.println();

        System.out.println("[clear] 전부 삭제");
        System.out.println("--------");
        list.clear();
        System.out.println("--------");
        System.out.println();

        System.out.println("[isEmpty] 비어있나?");
        System.out.println("--------");
        System.out.println(list.isEmpty());
        System.out.println("--------");
        System.out.println();
        
        
        if(list instanceof ArrayList) {        	
        	System.out.println("배열 크기 증가");
        	int defaultSize = 10; // ArrayList의 기본 할당 크기
        	for (int i = 0; i < 2 * defaultSize + 10; i++) list.add(1);
        	list.print();
        	System.out.println();
        	
        	System.out.println("배열 크기 감소");
        	for (int i = list.size(); i >= defaultSize >> 1; i--) list.remove(0);
        	list.print();
        	System.out.println();
        }
    }
}