package Task2;

public class Task2 {
    public static void main(String[] args) {
        //Сколько сверкает 1 огонёк
        final int LIVE_HOURS = 2;
        //Количество новых огней из сгоревших (b1)
        final int NEW_LIGHTS_FROM_OLD = 2;
        //Количество бенгальских огней
        final int c1 = 26;
        //Из скольки потухших огней можно получить 2 новых
        int b1 = 10;
        //Учёт сгоревших огней
        int oldLights = 0;
        //Считаем часы горения огня
        int totalHours = 0;

        int lightsCount = c1;

        while (lightsCount > 0) {
            lightsCount--;
            totalHours += LIVE_HOURS;
            oldLights++;
            if (oldLights == b1) {
                lightsCount +=2;
                oldLights = 0;
            }
        }

        System.out.println(String.format("Из %d огней можно получить %d часов непрерывного горения.", c1, totalHours));

    }
}
