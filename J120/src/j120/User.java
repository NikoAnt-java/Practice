package j120;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Cloneable {

    /**
     * Уникальный идентификатор пользователя.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Определяет является ли данный пользователь администратором системы.
     */
    private boolean isAdmin;

    /**
     * Конструктор по умолчанию.
     */
    public User() {
    }

    /**
     * Конструктор, определяющий все поля класса.
     *
     * @param id уникальный идентификатор пользователя.
     * @param name имя пользователя.
     * @param isAdmin задаёт значение true, если пользователь является
     * администратором системы.
     * @throws UserException выбрасывается в случаях, когда: - идентификатор
     * пользователя не уникален; - имя пользователя равно null или является
     * пустым. (Класс данного исключения определите самостоятельно).
     */
    public User(int id, String name, boolean isAdmin)
            throws UserException {
        // Реализация конструктора ...
        if (name != null && !name.trim().isEmpty()) {//проверка на пустые имена
            this.name = name;
            this.isAdmin = isAdmin;
            for (int i = 0; i < Name.numOfUsers; i++) {
                if (Name.users[i].id == id) {
                    throw new UserException();
                }
                System.out.println("");
            }
            this.id = id;
            Name.users[Name.numOfUsers++] = this;
        } else {
            throw new UserException();
        }
    }

    /**
     * Метод клонирует объект данного класса по следующим правилам: - имя
     * пользователя name и поле isAdmin дублируются; - для идентификатора id
     * выбирается новое уникальное значение (в данной задаче можно генерировать
     * случайное значение, например, с помощью метода Math.random()).
     *
     * @return ссылка на клон данного объекта.
     * @throws CloneNotSupportedException выбрасывается в случае, когда имя
     * пользователя равно null или является пустой строкой.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {// проверка id на уникальность
        User newUser = null;
        boolean badId;
        do {
            try {
                badId = false;
                int newId = (int) (Math.random() * 20000);
                newUser = new User(newId, name, isAdmin);
                System.out.println("Выполнено создание newUser " + newUser.toString());
// Реализация метода ...
            } catch (UserException ex) {
                System.out.println("Сработал clone()");
                badId = true;
            }
        } while (badId);
        return newUser;
    }

    /**
     * Метод сравнивает по содержанию текущий объект с объектом obj.
     *
     * @param obj ссылка на объект, с которым сравнивается текущий объект.
     * @return возвращает значение true, если имя пользователя name и значение
     * поля isAdmin у обоих объектов совпадают.
     */
//    public boolean equals(Object obj) {
//        return false;
//        // Реализация метода...
//    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {//проверка на нулевые значения
            return false;
        }
        if (getClass() != obj.getClass()) {//сравнение классов
            return false;
        }
        final User other = (User) obj;
        if (this.isAdmin != other.isAdmin) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
   /**
     * Метод возвращает хэш-код данного объекта. Алгоритм вычисления кода должен
     * учитывать имя пользователя и значение поля isAdmin.
     *
     * @return хэш-код объекта.
     */
//    public int hashCode() {
//        return 0;
//        // Реализация метода...
//    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (this.isAdmin ? 1 : 0);
        return hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;

    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", isAdmin=" + isAdmin + '}';
    }

}
