import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(navController: NavController) {
    val imageResources = listOf(
        R.drawable.hidden_love,
        R.drawable.falling_into_ur_smile,
        R.drawable.the_love_u_giveme,
        R.drawable.cloy,
        R.drawable.hotel_del_luna,
        R.drawable.chuang,
        R.drawable.alovesobeautiful,
        R.drawable.our_times,
        R.drawable.put_your,
        R.drawable.miracle,
    )
    val filmTitle = listOf(
        "Hidden Love",
        "Falling Into Your Smile",
        "The Love U Give Me",
        "Crash Landing On You",
        "Hotel Del Luna",
        "Chuang 2021",
        "A love So Beautiful",
        "Our Times",
        "Put Your Head on My Shoulders",
        "Miracle in Cell no 7"
    )
    val filmSinopsis = listOf(
        "Sang Zhi falls in love with Duan Jia Xu, the boy who often comes to her house to play games in her older brother's room. He is five years older than her. Sang Zhi had a crush on Duan Jia Xu when she was young, but they lost contact with each other for some reason. After she graduates, she joins the university in the city he is in, and during their day-to-day intimate and close interaction, they slowly fall in love.",
        "In the ultra-competitive world of e-sports, the all-male ZGDX OPL team is second to none. Armies of adoring female fans follow the team wherever it goes. But when one of the team’s star players suffers a hand injury, the tall, handsome, and notoriously hard-to-please ZGDX captain Lu Si Cheng will not be rushed into choosing a replacement.",
        "Five years ago, a young woman named Min Hui accidentally fell for a young man named Xin Qi. But things between them were complicated because Min Hui was pretending to be Xin Qi’s long lost childhood friend in a misguided way to help the friend who had died suddenly. Furthermore, Xin Qi suffered from a dangerous and potentially life-threatening heart condition, and Min Hui now desperately in love, didn't want to see him suffer. It didn't help matters that each time she tried to tell him the truth, he would cut her off, not believe her, or his heart condition would relapse. When he finally learned the entire truth, he cut all ties with her.",
        "After getting into a paragliding accident, South Korean heiress Yoon Se Ri crash lands in North Korea. There, she meets North Korean army officer Ri Jung Hyuk, who agrees to help her return to South Korea. Despite the tension between their countries, the two of them start falling for one another.",
        "Nestled deep in the heart of Seoul’s thriving downtown sits a curious hotel, the like of which no one has ever seen before. Old beyond measure, the building has stood for millennia, an ever-present testament to the fact that things are not always what they seem. Running this hotel is Jang Man Wol, a greedy, suspicious soul who has spent the past thousand years acting as the establishment’s CEO.",
        "A dorm diary of the Chuang 2021 trainees showing their daily lives at the Chuang camp.",
        "It starts off with high school classmates Chen Xiao Xi and Jiang Chen who are also neighbors. Xiao Xi, a cheerful girl who doesn't study much, is expressive about her admiration towards Jiang Chen, the popular guy known for his looks and high grades. Together with their fellow classmates the funny Lu Yang, athletic but loyal Jing Xiao, and cool swimming team member Wu Bo Song, they embark on high school life to university until their adult life.",
        "One day, Zhen Xin receives a chain letter, warning her of impending doom if she does not pass the message on. Naively, she passes it on to Hsu Tai Yu, the school's notorious gangster boss, her maths teacher, and Tao Min Min, the school's most popular girl. While Tai Yu was reading the letter, he gets injured in a car accident. After weeding out the letter's sender, the angry Tai Yu makes Zhen Xin his 'friend' and forces her to run errands for him in exchange for leaving Fei Fan alone, thus making her his errand-girl.",
        "Situ Mo is a graduating student. As someone who got used to having her whole life planned out for her, she is at a loss about her future and can't find the courage to make a decision for herself. Because the school districts have merged, physics major Gu Weiyi barges into her life. They clash repeatedly without noticing that they are slowly walking into each other's hearts. To their surprise, they accidentally end up having to live together.",
        "Lee Yong Gu is a mentally impaired father, who lives in a run-down house along with his daughter of the same age, Ye Seung. One day, he gets into a physical altercation with the police commissioner, who has just purchased the last Sailor Moon backpack for his daughter, a gift Yong Gu was saving up to buy for Ye Seung. Soon after, the police commissioner's daughter dies in a freak accident while she is taking Yong Gu to another store that sells the same backpack. When he tries to resuscitate her, a woman witnesses him and mistakes him to be molesting her. Yong Gu is falsely accused of the abduction, murder, and rape of a minor. The police quickly take advantage of his disability and force him to admit to committing the crimes, while ignoring exonerating evidence. Yong Gu is imprisoned and assigned to Cell No. 7, the harshest cell in a maximum security prison."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Favorite") },
                modifier = Modifier.shadow(elevation = 4.dp),
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = { padding ->
            LazyVerticalGrid(
                GridCells.Fixed(2), // Ganti dengan jumlah kolom yang Anda inginkan
                modifier = Modifier.padding(padding)
            ) {
                items(imageResources.size) { index ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("detail/${filmTitle[index]}/${filmSinopsis[index]}/${imageResources[index]}")
                            }
                    ) {
                        Box(modifier = Modifier.size(200.dp)) {
                            val image = painterResource(id = imageResources[index])
                            Image(
                                painter = image,
                                contentDescription = "Gambar untuk Card $index",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        }
    )
}
