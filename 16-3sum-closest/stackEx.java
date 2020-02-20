public class stackEx {
    public void findName(Student[] arr, int id) {
        int currentID = 0;
        for (int i=0; i<arr.lenght; i++) {
            currentID = Men[arr + 2*i + 0];
            if (currentID == id) {
                String name = Mem[arr + 2*i + 1];
                System.out.printf("student id:%d, name:%s",id,name);
                break;
            }
        }

        if (currentID != id) {
            throw new IllegalArgumentException("The id is not found in the array!");
        }
    }

}

class Student {
    String name;
    int id;
}

