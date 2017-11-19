import models.ReminderItemModel

object DataManager {
    fun provideData() =
            listOf(ReminderItemModel("pay bills"),
                    ReminderItemModel("go to doctor"),
                    ReminderItemModel("feed the cat"),
                    ReminderItemModel("meet Jane")
            )
}