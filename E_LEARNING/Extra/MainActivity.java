package com.example.e_learning;

import java.util.ArrayList;

import com.example.database.ExtraData;
import com.example.database.MySQLiteOpenHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private ImageButton imgVol, imgExer, imgTest, imgExtra;
	private TextView tvVol, tvExer, tvTest, tvExtra;
	private Context context;
	private MySQLiteOpenHelper database;
	private ArrayList<ExtraData> arr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		database = new MySQLiteOpenHelper(this);
		arr = database.getAllExtra();
		tvVol = (TextView) findViewById(R.id.tvVol);
		tvExer = (TextView) findViewById(R.id.tvExer);
		tvTest = (TextView) findViewById(R.id.tvTest);
		tvExtra = (TextView) findViewById(R.id.tvExtra);
		imgVol = (ImageButton) findViewById(R.id.imgButton1);
		imgVol.setOnClickListener(this);
		imgExer = (ImageButton) findViewById(R.id.imgButton2);
		imgExer.setOnClickListener(this);
		imgTest = (ImageButton) findViewById(R.id.imgButton3);
		imgTest.setOnClickListener(this);
		imgExtra = (ImageButton) findViewById(R.id.imgButton4);
		imgExtra.setOnClickListener(this);

		if (arr.size() == 0) {
			addDbExtra();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		switch (v.getId()) {
		case R.id.imgButton1:
			intent = new Intent(MainActivity.this, Volcabulary.class);
			startActivity(intent);
			finish();
			break;
		case R.id.imgButton2:
			intent = new Intent(MainActivity.this, Exercise.class);
			startActivity(intent);
			finish();

			break;
		case R.id.imgButton3:
			intent = new Intent(MainActivity.this, Test.class);
			startActivity(intent);
			finish();
			break;
		case R.id.imgButton4:
			intent = new Intent(MainActivity.this, Extra.class);
			startActivity(intent);
			finish();
			break;
		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}

	void addDbExtra() {
		ExtraData st1 = new ExtraData(
				"A Baby and a Sock",
				"The mother gave her baby a red apple. The baby tried to eat the apple. His mouth was too small. And he didn't have any teeth. His brother took the apple. His brother ate the apple. The baby cried. His brother gave the baby a blue ball to play with. The baby smiled. His brother took the ball from the baby. He rolled the ball on the floor. The brown and white dog picked up the ball. The dog chewed on the ball. The baby cried again. His brother picked up the cat. He put the cat on the bed with the baby. The baby pulled the cat's tail. The cat jumped off the bed. The dog chased the cat. The baby cried again. His brother let the baby hold a sock. The baby played with the sock. The baby was happy.");
		ExtraData st2 = new ExtraData(
				"Birds and a Baby",
				"The baby was lying on her back. A blue bird flew in through the window. The blue bird had blue eyes. It sat on the baby's crib. The bird had a bell around its neck. The bell rang. The baby smiled. The baby reached for the bell. The bird shook its head. The bell fell off the bird's neck. It fell next to the baby. The baby picked up the bell. The baby rang the bell. Another blue bird flew in through the window. This blue bird also had blue eyes. The baby had brown eyes. The birds looked at the baby. The baby looked at the birds. The baby rang the bell again. Both birds flew away. The baby started to cry. His mama came into the room. The baby smiled. Mama saw the bell. She asked the baby where the bell came from. The baby pointed at the window.");
		ExtraData st3 = new ExtraData(
				"An Apple Pie",
				"The tree was full of red apples. The farmer was riding his brown horse. He stopped under the tree. He reached out and picked an apple off a branch. He bit into the raw apple. He enjoyed the apple. His horse turned its head to look at him. The farmer picked another apple off the tree. He gave it to the horse. The horse ate the raw apple. The horse enjoyed the apple. The farmer put a dozen apples into a bag. He rode the horse back home. He put the horse in the barn. He walked into his house. The cat rubbed up against his leg. He gave the cat a bowl of warm milk. He sat down on the sofa. He opened a book to read. His wife came home. She cooked the raw apples. She made an apple pie. They ate bread and hot soup for dinner. They enjoyed the bread and soup. They had hot apple pie for dessert. They both enjoyed the apple pie");
		ExtraData st4 = new ExtraData(
				"Hugging is",
				"Hugging is healthy. It helps the immune system, cures depression, reduces stress and induces sleep. It’s invigorating, rejuvenating and has no unpleasant side effects. Hugging is nothing less than a miracle drug.Hugging is all natural. It is organic, naturally sweet, no artificial ingredients, non-polluting, environmentally friendly and 100 percent wholesome.Hugging is the ideal gift. Great for any occasion, fun to give and receive, shows you care, comes with its own wrapping and, of course, fully returnable.Hugging is practically perfect. No batteries to wear out, inflation-proof, non-fattening, no monthly payments, theft-proof and nontaxable.Hugging is an underutilized resource with magical powers. When we open our hearts and arms we encourage others to do the same.Think of the people in your life. Are there any words you’d like to say? Are there any hugs you want to share? Are you waiting and hoping someone else will ask first? Please don’t wait! Initiate! – Charles Faraone. We need four hugs a day for survival, eight hugs a day for maintenance, and twelve hugs a day for growth. -Virginia Satir",
				5);
		ExtraData st5 = new ExtraData(
				"A broken pot",
				"A water bearer in India had two large pots, each hung on the ends of a pole which he carried across his neck. One of the pots had a crack in it, while the other pot was perfect and always delivered a full portion of water. At the end of the long walk from the stream to the house, the cracked pot arrived only half full. For a full two years this went on daily, with the bearer delivering only one and a half pots full of water to his house. Of course, the perfect pot was proud of its accomplishments, perfect for which it was made. But the poor cracked pot was ashamed of its own imperfection, and miserable that it was able to accomplish only half of what it had been made to do. After two years of what it perceived to be a bitter failure, it spoke to the water bearer one day by the stream. “I am ashamed of myself, and I want to apologize to you. I have been able to deliver only half my load because this crack in my side causes water to leak out all the way back to your house. Because of my flaws, you have to do a lot of this work, and you don’t get full value from your efforts,” the pot said. The bearer said to the pot, “Did you notice that there were flowers only on your side of the path, but not on the other pot’s side? That’s because I have always known about your flaw, and I planted flower seeds on your side of the path, and every day while we walk back, you’ve watered them. For two years I have been able to pick these beautiful flowers to decorate the table. Without you being just the way you are, there would not be this beauty to grace the house.”");
		ExtraData st6 = new ExtraData(
				"Puppies for sale",
				"A store owner was tacking a sign above his door that read “Puppies for Sale”. Signs have a way of attracting children, and soon a little boy appeared at the store and asked, “How much are you gonna sell those puppies for?” The store owner replied, “Anywhere from $30 to $50.” The little boy reached into his pocket and pulled out some change. “I have $2.37, can I look at them?” The store owner smiled and whistled. Out of the back of the store came his dog running down the aisle followed by five little puppies. One puppy was lagging considerably behind. Immediately the little boy singled out the lagging, limping puppy.“What’s wrong with that little dog?” he asked. The man explained that when the puppy was born the vet said it had a bad hip socket and would limp for the rest of it’s life. The little boy got really excited and said “That’s the puppy I want to buy!” The man replied “No, you don’t want to buy that little dog. If you really want him, I’ll give him to you.” The little boy got upset. He looked straight into the man’s eyes and said, “I don’t want you to give him to me. He is worth every bit as much as the other dogs and I’ll pay the full price. In fact, I will give you $2.37 now and 50 cents every month until I have him paid for.” The man countered, “You really don’t want to buy this puppy, son. He’s never gonna be able to run, jump and play like other puppies.” The little boy reached down and rolled up his pant leg to reveal a badly twisted, crippled left leg supported by a big metal brace. He looked up at the man and said, “Well, I don’t run so well myself and the little puppy will need someone who understands.” The man was now biting his bottom lip. Tears welled up in his eyes… He smiled and said, “Son, I hope and pray that each and every one of these puppies will have an owner such as you.”");
		ExtraData st7 = new ExtraData(
				"An act of kindness",
				"President Abraham Lincoln often visited hospitals to talk with wounded soldiers during the Civil War. Once, doctors pointed out a young soldier who was near death and Lincoln went over to his bedside. “Is there anything I can do for you now?” asked the president. The soldier obviously didn’t recognize Lincoln, and with some effort he was able to whisper, “Would you please write a letter to my mother?” A pen and paper were provided and the president carefully began to write down what the young man was able to say: “My dearest mother, I was badly hurt while doing my duty. I’m afraid I’m not going to recover. Don’t grieve too much for me, please. Kiss Mary and John for me. May God bless you and father.” The soldier was too weak to continue, so Lincoln signed the letter for him and added, “Written for your son by Abraham Lincoln.”  The young man asked to see the note and was astonished when he discovered who had written it. “Are you really the president?” he asked. “Yes, I am,” Lincoln replied quietly. Then he asked if there was anything else he could do. “Would you please hold my hand?” the soldier asked. “It will help to see me through to the end.” In the hushed room, the tall gaunt president took the soldier’s hand in his and spoke warm words of encouragement until death came. – The Best of Bits & Pieces");
		ExtraData st8 = new ExtraData(
				"Heart song",
				"There was a great man who married the woman of his dreams. With their love, they created a little lovely girl. When the little girl was growing up, the great man would hug her and tell her, “I love you, little girl.” The little girl would pout and say, “I’m not a little girl anymore.” Then the man would laugh and say, “But to me, you’ll always be my little girl.” The little girl who-was-not-little-anymore decided to leave her home and went into the world. As she learned more about herself, she learned more about the man. One of his strengths was his ability to express his love to his family. It didn’t matter where she went in the world, the man would call her and say, “I love you, little girl.” The day came when the little girl who-was-not-little-anymore received anunexpected phone call. The great man was damaged. He had had a stroke. He couldn’t talk, smile, walk, hug, dance or tell the little girl who-was-not-little-anymore that he loved her. And so she went to the side of the great man. When she walked into the room and saw him, he looked small and not strong at all. He looked at her and tried to speak, but he could not. The little girl did the only thing she could do. She sat next to the great man, and drew her arms around the useless shoulders of her father. Her head on his chest, she thought of many things. She remembered she had always felt protected and cherished by the great man. She felt grief for the loss she was to endure, the words of love that had comforted her. And then she heard from within the man, the beat of his heart. The heart beat on, steadily unconcerned about the damage to the rest of the body. And while she rested there, the magic happened. She heard what she needed to hear. His heart beat out the words that his mouth could no longer say… I love you, little girl… I love you, little girl… and she was comforted.");
		ExtraData st9 = new ExtraData(
				"Don’t Be Late",
				"He was late. He was always late. Why did time always go so fast? Time always went too fast. He looked at his watch. He looked at the clock on the wall. They both said 6:10. He had to leave in 10 minutes. But first he had to shave. Then he had to brush his teeth. Then he had to get dressed. Shaving took time. Brushing his teeth took time. Getting dressed took time. But he had only 10 minutes. So he turned off the TV. He turned off the radio, too. He turned off the table lamp. He went into the bathroom. He shaved. He brushed his teeth. He went into his bedroom. He got dressed. He looked at his watch. He looked at the clock on the wall. They both said 6:25. He had to hurry. He went out to his car. He drove fast. He slowed down at a stop sign. A cop saw him. The cop wrote him a ticket. Why didn't you stop at the stop sign? the cop asked. But officer, I was in a hurry, he said. The cop gave him the ticket. The cop said, Leave home earlier next time");
		ExtraData st10 = new ExtraData(
				"A Good Meal",
				"The children were hungry. They looked out the window. Where was their mother? She walked into the house. The children ran over to her. Mama, we're so hungry, they both said. She said lunch was coming. She walked into the kitchen. She opened a can of chicken soup. She poured the soup into a pot. She added water. She put the pot on the stove. She made two peanut butter and jelly sandwiches. She sliced an apple. The soup was hot. She poured it into two bowls. She put the sandwiches on two plates. She put apple slices on each plate. She put the bowls and plates on the table. The children ran to the table. Thank you, mommy! they said. Then they started eating. The cat and the dog watched them eat");
		ExtraData st11 = new ExtraData(
				"Life Is Good",
				"I am happy. I have many friends. I have a large family. I have four brothers and four sisters. I am in the middle. Four brothers are older than me. Four sisters are younger than me. I go to school. I am in the sixth grade. I like my teachers. My teachers like me. I have friends in every class. My favorite class is hiExtraData. I like to read about hiExtraData. HiExtraData is a ExtraData about our past. Soon we will all be hiExtraData. Then kids in school will read about us. I hope they like our stories. My best friend is Bobby. Bobby and I do many things together. We swim together. We play basketball together. We ride our bikes together. I have many other friends. We all go to the mall on weekends. We go to movies. We go to restaurants. We tell jokes. We laugh. We have fun. Life is great.");
		ExtraData st12 = new ExtraData(
				"Corn for People and Animals",
				"The farmer drives a tractor. The tractor digs up the ground. He plants yellow corn in the ground.  He plants the yellow corn in the spring. The corn grows in the summer. The rain helps the corn grow. If there is no rain, the corn dies. If there is a lot of rain, there is a lot of corn. He harvests the yellow corn in late summer. He sells the corn at his vegetable stand. He sells one ear for 25 cents. He sells four ears for $1. He sells all his corn in just one month. The neighbors love his corn. The corn is fresh. It is bright yellow. It is tasty. It is delicious. The birds love his corn, too. They don't pay for it. They eat it while it is in the field. They don't cook it. They eat it raw. The farmer doesn't get angry. Birds have to eat, too. So do cows. The farmer has one cow. He gives his cow fresh corn every summer. The cow loves the corn. It eats a lot of yellow corn in the summer. Sometimes it makes yellow milk. ");
		ExtraData st13 = new ExtraData(
				"Daddy Likes Beer",
				"The little girl was thirsty. She wanted something to drink. She opened the refrigerator. She looked inside. She saw milk. She saw soda. She saw orange juice. She saw beer. She wondered what beer tasted like. Her daddy drank beer every day. Beer must be good. If Daddy likes it, it must taste good. She grabbed a can of beer. She opened the beer. She smelled it. She couldn't smell anything. She swallowed some. Yuck! she said. The beer was horrible. How could Daddy drink that stuff? She put the can back into the refrigerator. Daddy could finish it when he got home. She grabbed the milk. She poured some into a glass. She added chocolate syrup to the milk. She stirred the milk. Now she had chocolate milk. She loved chocolate milk. Poor Daddy, she thought. He likes beer more than chocolate milk.   ");
		ExtraData st14 = new ExtraData(
				"She Writes Letters",
				"She will write a letter to her grandma. She will write about her day at school. She will write about her classmates. She will write about her teacher. She will write about the classroom. She will write about her school bus. She will write about her school bus driver. She won't write about her pets. She won't write about her fat black cat. She won't write about her little red dog. She won't write about her soft white rabbit. She won't write about her big brown horse. That's because she doesn't have a big brown horse. Not yet. She wants a big brown horse for her birthday. She will write a letter to her daddy about the horse. She will ask her daddy for a big brown horse. A big brown horse will be a perfect birthday gift. She will never want another birthday gift. A horse will make her happy forever. The letter to her daddy will ask for a horse. Maybe daddy will give her a horse. Then she will write a new letter to her grandma. She will tell grandma about the new brown horse.  ");
		ExtraData st15 = new ExtraData(
				"Squares and Circles",
				"Different shapes and forms are everywhere. Boxes and street signs are square or rectangular. Balls and wheels are round. The sun and moon are round. Wedding rings are round. Eggs and light bulbs are almost round. Pyramids and arrow tips are triangular. Tables and books are square or rectangular. Doors and refrigerators are rectangular. A stop sign has eight sides. A triangle has three sides. Pencils and pens are long and round. Your toes are short and round. Many things have various shapes. Humans and animals have various shapes. Faces have various shapes. Clouds have various shapes. Houses and buildings have various shapes. Airplanes have various shapes. Other things have weird shapes. Bicycles and tricycles have weird shapes. Countries have weird shapes. Tools and machines have weird shapes. Shapes can be beautiful, too. Boys think that a skateboard or a soccer ball has a beautiful shape. Men think that women have the most beautiful shape of all.  ");
		ExtraData st16 = new ExtraData(
				"Homeless People",
				" Los Angeles is a big city. There are millions of people here. But thousands of people have no home. They are homeless people. They live on the sidewalks. They sleep on the sidewalks. They are called street people. They don't have cars. They have shopping carts. They fill the carts with their belongings. They put their extra clothes into the carts. They put their blankets into the carts. Many homeless people live downtown. They live near the newspaper building. They live near the courthouse. They live near fancy condos. They have no money. They sit on the sidewalk all day. People walk by them. They ask people for money. People say they don't have any money. There are missions downtown. These missions feed homeless people. They give them free lunches. They feed them every day. Some missions have beds. Homeless people sleep in these beds. But there are more homeless people than beds. There are not enough beds for the homeless people. So most homeless people sleep on the sidewalk. They sleep next to their shopping carts. ");
		ExtraData st17 = new ExtraData(
				"Go to the Park",
				"Chuck wanted to go to the park after dinner. His mom wanted him to stay home after dinner. She didn't want him to go to the park. She said it was dark at the park. But Chuck said it wasn't dark at the park. There are lights at the park, Mom, he said. But she said there were only a few lights at the park. She said there were many dark places in the park. Bad people go to the park at night, she said. Bad people do bad things. They do bad things to good people. You are a good person. I don't want something bad to happen to you. Chuck said, Nothing bad will happen to me. I will go with my two friends. We will be together. All three of us will be together. We will stay away from the dark places. We will stay under the lights.");
		ExtraData st18 = new ExtraData(
				"A Birthday Dress",
				"It was Ellen's 12th birthday. Ellen was 12 years old. Her mom took her shopping. They went shopping at the mall. You can pick out a dress. You can pick out a pretty dress, Mom said. I will pick out a pretty, blue dress, Ellen said. They went into JC Penney. JC Penney sells lots of dresses. Ellen saw a blue dress that she liked. I like that dress, Mom, she said. She took the dress into the dressing room. She put on the dress. It fit her well. She walked out of the dressing room. The dress fits you well, said Mom. Can I have it? Ellen asked. Of course you can have it, dear. It's your birthday present, said Mom. But it's not on sale, said Ellen. We always buy everything on sale. It's your birthday, dear. On your birthday, we can pay full price, said Mom.");
		ExtraData st19 = new ExtraData(
				"A Small Apartment",
				"The big family lived in a one-bedroom apartment. Their apartment had only one bedroom. Mom and Dad slept in the bedroom. The two babies also slept in the bedroom. Four people slept in the bedroom. Four children slept in the living room. Two sisters slept in the living room. Two brothers slept in the living room. All four of them slept in the living room. They slept on air mattresses. They leaned the air mattresses against the wall in the daytime. They put the air mattresses on the floor in the nighttime. They all liked to sleep on the air mattresses. But the girls didn't like to sleep next to the boys. Daddy, we don't like to sleep next to the boys. We want our own bedroom. When will we get our own bedroom? asked one girl. You'll get your own bedroom when I get a better job, Daddy said.");
		ExtraData st20 = new ExtraData(
				"Where’s Kitty?",
				"Kathy said, Here, Kitty, Kitty! But Kitty didn't come. Where was Kitty? Kitty always came home for dinner. Kathy said it again. Here, Kitty, Kitty! But Kitty didn't come. Kathy stayed up late. She waited for Kitty to come in. Kitty always came in through the pet door. Kathy finally fell asleep. She woke up the next morning. Here, Kitty, Kitty! she said. But Kitty was not home. Where could Kitty be, Kathy thought. Where could Kitty be? Kathy called the police. A policeman answered the phone. My cat didn't come home last night, Kathy said. I'm sorry to hear that, said the policeman. What is your cat's name? Kathy said her cat's name was Kitty. That's a nice name, said the policeman. What color is Kitty? Kathy said that Kitty was black. Okay, don't worry, said the policeman. We'll find Kitty. Someone probably ran over her.");
		ExtraData st21 = new ExtraData(
				"Make Some Coffee",
				"She took the bag of coffee beans out of the freezer. She kept them in the freezer because the instructions on the bag said that is the best place. She poured the beans into the grinder. She pressed the grinder button for 10 seconds. Now she had ground coffee. She put a paper filter into a plastic cone. She put the cone on top of a coffee cup. She poured the ground coffee into the cone. Then she poured hot water into the cone. The hot water dripped through the ground coffee. She waited until the cup was full of hot coffee. She threw away the filter and the ground coffee. She took her cup of coffee to the dining room table. She sipped her coffee while she read the newspaper.  ");
		ExtraData st22 = new ExtraData(
				"Time to Shop",
				"It was time to go to the market. He had no bananas, no apples, and no milk. He got into his car and drove to the market. It was only five minutes away. The parking lot was almost empty. Good, he thought. He wouldn't have to stand in a long line. He parked his car and walked over to the shopping cart area. He pulled out one of the carts and pushed it ahead of him into the store. Inside, he grabbed an alcohol wipe and wiped the handle of the cart. Then he grabbed another wipe and wiped his own hands. You can never be too careful, he thought. He turned left and walked over to the produce section. Today was his lucky day. Apples were on sale, a dollar a pound. Usually they were two dollars a pound or more. He put 10 apples into a plastic bag and weighed the bag. It was three pounds. He walked over to the bananas. They were the regular price, 79 cents a pound. He bought three pounds of bananas. When he saw the carrots, he remembered that he needed carrots, too. He put a two-pound bag of carrots into his cart. They were only $1.29. He walked to the dairy section and saw that a gallon of milk was $4. He put one into his cart and walked back to the front of the store. He paid for his food, got his receipt, and walked out to his car. He put the food into his trunk and drove home.        ");
		ExtraData st23 = new ExtraData(
				"The Painter",
				"The painter was on the ladder. The ladder was on the sidewalk. The ladder was leaning against the wall. The painter was standing about 10 feet above the sidewalk. He was holding a spray gun. He was painting the wall with a spray gun. He was painting the wall white. The wall was part of the 99 Cents store. The store had big glass windows. The painter had taped plastic over the windows. Plastic covered the big glass windows. The painter wore goggles over his eyes. The goggles covered his eyes. Customers walked into the store. Customers walked out of the store. They walked under the ladder. They walked under the painter. Tiny drops of paint fell on the customers. Tiny drops of paint fell on the cars. Tiny drops of paint fell on the sidewalk. The painter didn't care. Tiny drops of paint were not his problem.   ");
		ExtraData st24 = new ExtraData(
				"Catch Some Fish",
				"Let's go fishing, said the father. That's a good idea, said the mother. They put the kids into the car. They put the fishing rods into the car. They put the jar of worms into the car. They drove to the lake. The lake was huge. The name of the lake was Yellow Lake. It had yellow sand all around it. The sand looked like gold. But it wasn't gold. It was only sand. They parked the car. They got out of the car. They sat down on the sand. They put the worms on the hooks. They put the hooks into the water. They waited for the fish to bite the bait. They waited 30 minutes. Then one of the kids caught a fish. It was a trout. It was a rainbow trout. It had many colors, like a rainbow. But its belly was white. They took the trout off the hook. They put the trout into a bucket of water. The trout swam around in tiny circles. It was confused. Where did the big lake go? They caught three more trout. Then they went home. They had delicious fried fish for dinner. Can we go fishing every day? the kids asked their parents.");
		ExtraData st25 = new ExtraData(
				"The Birthday Cake",
				"It was Jenny's fourth birthday. She was four years old. Her mom baked a cake for her. Her mom baked a chocolate cake for her. The cake had two layers. Her mom put vanilla frosting on the bottom layer. Her mom put vanilla frosting on the top layer. Her mom put vanilla frosting all around the cake. Now the chocolate cake was completely white. Her mom put four pink candles on top of the cake. Her dad lit the four pink candles. The four pink candles were lit. Jenny's mom and dad sat down next to Jenny. They sang Happy Birthday to her. Happy birthday to you, they sang. Jenny sang with her mom and dad. Happy birthday to me, she sang. Her mom said, Now make a wish and blow out the candles. Jenny made a wish. Then she blew out all four pink candles.");
		ExtraData st26 = new ExtraData(
				"Life Will Be Better",
				"He was poor. He needed more money. He needed a good job. He had a job. But it wasn't a good job. It was a bad job. He was a waiter. He worked in a restaurant. It was a cheap restaurant. The meals were cheap. The customers were cheap. They usually gave him quarters for tips. Sometimes they gave him a dollar. Sometimes they gave him nothing. That made him angry. Why did they give him nothing? He was polite. He was helpful. Yet they gave him nothing. He wanted to kick those customers. But then he would go to jail. He didn't want to go to jail. So he went to school. School was free. He wanted to be a mechanic. He liked to fix things. He wanted to fix cars. He wanted to own a car shop. He would make money. He would hire other mechanics. They would work for him. He would buy a house. He would get married. He would have a family. Life would be good. Right now life was bad. But he would make it better.  ");
		database.insertExtra(st1);
		database.insertExtra(st2);
		database.insertExtra(st3);
		database.insertExtra(st4);
		database.insertExtra(st5);
		database.insertExtra(st6);
		database.insertExtra(st7);
		database.insertExtra(st8);
		database.insertExtra(st9);
		database.insertExtra(st10);
		database.insertExtra(st11);
		database.insertExtra(st12);
		database.insertExtra(st13);
		database.insertExtra(st14);
		database.insertExtra(st15);
		database.insertExtra(st16);
		database.insertExtra(st17);
		database.insertExtra(st18);
		database.insertExtra(st19);
		database.insertExtra(st20);
		database.insertExtra(st21);
		database.insertExtra(st22);
		database.insertExtra(st23);
		database.insertExtra(st24);
		database.insertExtra(st25);
		database.insertExtra(st26);
	}

}
