import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    // Конструкторы
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Неверная емкость: " + initialCapacity);
        }
        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    // Добавление элемента в конец
    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    // Добавление элемента по индексу
    public void add(int index, E element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);

        // Сдвиг элементов вправо
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Получение элемента по индексу
    @SuppressWarnings("unchecked")
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // Установка элемента по индексу
    @SuppressWarnings("unchecked")
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    // Удаление элемента по индексу
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkIndex(index);
        E removedElement = (E) elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }

        elements[--size] = null; // Помощь сборщику мусора
        return removedElement;
    }

    // Удаление элемента по значению
    public boolean remove(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // Поиск индекса элемента
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    // Проверка наличия элемента
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    // Размер коллекции
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистка коллекции
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Преобразование в массив
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        return (E[]) Arrays.copyOf(elements, size);
    }

    // Вспомогательные методы
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
    }

    // Итератор
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() {
            return (E) elements[currentIndex++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--currentIndex);
        }
    }

    // Тестовый метод
    public static void main(String[] args) {
        System.out.println("=== Тестирование собственной коллекции MyArrayList ===");

        MyArrayList<String> myList = new MyArrayList<>();

        // Добавление элементов
        myList.add("Первый");
        myList.add("Второй");
        myList.add("Третий");
        myList.add(1, "Новый второй");

        System.out.println("\nСодержимое коллекции:");
        for (String item : myList) {
            System.out.println("- " + item);
        }

        System.out.println("Размер: " + myList.size());

        // Получение и изменение элементов
        System.out.println("\nЭлемент с индексом 2: " + myList.get(2));
        myList.set(2, "Измененный третий");

        // Поиск элементов
        System.out.println("\nПоиск 'Первый': индекс = " + myList.indexOf("Первый"));
        System.out.println("Содержит 'Второй'? " + myList.contains("Второй"));

        // Удаление
        System.out.println("\nУдаляем элемент с индексом 0: " + myList.remove(0));
        System.out.println("Удаляем 'Второй': " + myList.remove("Второй"));

        System.out.println("После удаления:");
        for (String item : myList) {
            System.out.println("- " + item);
        }

        // Преобразование в массив
        System.out.println("\nПреобразование в массив:");
        String[] array = myList.toArray();
        for (String item : array) {
            System.out.println("- " + item);
        }

        // Очистка
        myList.clear();
        System.out.println("\nПосле очистки. Размер: " + myList.size());
        System.out.println("Пустая? " + myList.isEmpty());

        // Тестирование с числами
        System.out.println("\n=== Тестирование с целыми числами ===");
        MyArrayList<Integer> numbers = new MyArrayList<>(5);

        for (int i = 1; i <= 15; i++) {
            numbers.add(i * 10);
        }

        System.out.println("Числа (каждое увеличенное в 10 раз):");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nРазмер: " + numbers.size());
        System.out.println("Элемент 5: " + numbers.get(4));

        System.out.println("\nТестирование завершено успешно!");
    }
}