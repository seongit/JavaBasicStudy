enum Direction { EAST, SOUTH, WEST, NORTH }

class Ex12_5 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;
        Direction d2 = Direction.valueOf("WEST");
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1="+d1);
        System.out.println("d2="+d2);
        System.out.println("d3="+d3);

        System.out.println("d1==d2 ? "+ (d1==d2));
        System.out.println("d1==d3 ? "+ (d1==d3));
        System.out.println("d1.equals(d3) ? "+ d1.equals(d3));
//		System.out.println("d2 > d3 ? "+ (d1 > d3)); // 에러 열거형 상수에 비교 연산자 사용불가
        // 열거형 상수간의 비교에는 '=='을 사용할 수 있다. equlas()가 아닌 '=='로 비교가 가능하다는 것은 그만큼 빠른 성능을 제공한다는 것이다.
        // 그러나 '<','>'와 같은 비교 연산자는 사용할 수 없고 compareTo()는 사용 가능하다
        System.out.println("d1.compareTo(d3) ? "+ (d1.compareTo(d3))); // compareTo()는 사용 가능
        System.out.println("d1.compareTo(d2) ? "+ (d1.compareTo(d2)));

        switch(d1) {
            case EAST: // Direction.EAST라고 쓸 수 없다
                System.out.println("The direction is EAST."); break;
            case SOUTH:
                System.out.println("The direction is SOUTH."); break;
            case WEST:
                System.out.println("The direction is WEST."); break;
            case NORTH:
                System.out.println("The direction is NORTH."); break;
            default:
                System.out.println("Invalid direction."); break;
        }

        Direction[] dArr = Direction.values();

        for(Direction d : dArr)  // for(Direction d : Direction.values())
            System.out.printf("%s=%d%n", d.name(), d.ordinal());
        // int ordinal() 열거형 상수가 정의된 순서를 반환한다. (0부터 시작)
    }
}