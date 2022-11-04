package com.example.internshipsfera.data
import com.github.javafaker.Faker

class FakeLinks {

    private val faker = Faker()
    private val photoUrl = listOf(
        "https://sun1-84.userapi.com/s/v1/ig2/4CK1kPleOQmLZaq2DaHgpplVULvx4I7cbuQaxOqcNltA9gsDG3b-5U_Fs4vpEK73buzNG5honnAh7CKby0pX3-7n.jpg?size=200x200&quality=96&crop=139,1,680,680&ava=1",
        "https://avatars.mds.yandex.net/i?id=29084ff104567ebc13ac631b3514af6b_sr-7011986-images-thumbs&n=13",
        "https://static9.tgstat.ru/channels/_100/ef/ef2a57a48d7bf0635058d0531200a06d.jpg",
        "https://avatars.dzeninfra.ru/get-zen-logos/200214/pub_5ff5c2f4411801342259ebc3_5ff5dbacfe4e686f6ab1713d/xxh",
        "https://sun9-86.userapi.com/impf/c622722/v622722019/84c0/Tzk6T-f47iE.jpg?size=320x320&quality=96&sign=962bb0aba459fad993db86065077bb99&c_uniq_tag=DIGvY-nF-Lt301_IaGW2lYxJk4hpGEZfrl2lfGnYQ7U&type=album",
        "https://pbs.twimg.com/media/Cf_4vA5UUAEaPbT.jpg",
        "https://sun9-23.userapi.com/sun9-54/s/v1/ig1/FKkpKKe33aJoBRNi81Indkah289chaiybBHWzmFKe2cG-_pd7yDZIwXJU5xKKdPp52NcoFw4.jpg?size=200x200&quality=96&crop=149,0,500,500&ava=1",
        "https://sun1-99.userapi.com/s/v1/ig1/8u_eVtgo6cZd78FsdFiJG6FWet_OuTca2PIyrkGJX_esx-fsfb1yW5zzWHX-txUdzF2YIIj2.jpg?size=200x200&quality=96&crop=55,409,598,598&ava=1",
        "https://sun1-83.userapi.com/s/v1/ig2/BzbMhQ2x7Z0ynyKAK2PSVFwvWk7kvERjO44j1-ysYeTlbJnUzIfmaHhGex_L_yRoti7yFcm2ZSO1-X6nO8QKGOw_.jpg?size=200x200&quality=96&crop=163,1,873,873&ava=1",
        "https://i.pinimg.com/280x280_RS/d0/81/f3/d081f3f6d78d8e49b982e85dac4eebce.jpg"
    )

    fun getPersonList(): List<Account> {
        var counter = 0
        val list = mutableListOf<Account>()
        for (i in 1..40) {
            if (counter < 9) {
                list.add(
                    Account(
                        id = i,
                        name = faker.name().fullName(),
                        isSubscribe = false,
                        avatarUrl = photoUrl[counter]
                    )
                )
                counter++
            } else {
                list.add(
                    Account(
                        id = i,
                        name = faker.name().fullName(),
                        isSubscribe = false,
                        avatarUrl = photoUrl[counter]
                    )
                )
                counter = 0
            }
        }
        return list
    }
}