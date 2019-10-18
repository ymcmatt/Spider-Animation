/**
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @author Zezhou Sun <micou@bu.edu>
 * @since Spring 2011
 */

import java.util.HashMap;
import java.util.Map;

public class TestCasesSpider extends CyclicIterator<Map<String, Configuration>> {

	public static String LEFT_LEG_1_JOINT_3 = "LegLeft13";
	public static String LEFT_LEG_1_JOINT_2 = "LegLeft12";
	public static String LEFT_LEG_1_JOINT_1 = "LegLeft11";
	public static String LEFT_LEG_2_JOINT_3 = "LegLeft23";
	public static String LEFT_LEG_2_JOINT_2 = "LegLeft22";
	public static String LEFT_LEG_2_JOINT_1 = "LegLeft21";
	public static String LEFT_LEG_3_JOINT_3 = "LegLeft33";
	public static String LEFT_LEG_3_JOINT_2 = "LegLeft32";
	public static String LEFT_LEG_3_JOINT_1 = "LegLeft32";
	public static String RIGHT_LEG_1_JOINT_3 = "LegRight13";
	public static String RIGHT_LEG_1_JOINT_2 = "LegRight12";
	public static String RIGHT_LEG_1_JOINT_1 = "LegRight11";
	public static String RIGHT_LEG_2_JOINT_3 = "LegRight23";
	public static String RIGHT_LEG_2_JOINT_2 = "LegRight22";
	public static String RIGHT_LEG_2_JOINT_1 = "LegRight21";
	public static String RIGHT_LEG_3_JOINT_3 = "LegRight33";
	public static String RIGHT_LEG_3_JOINT_2 = "LegRight32";
	public static String RIGHT_LEG_3_JOINT_1 = "LegRight31";
	public static String BODY_NAME = "body";
	public static String HEAD_NAME = "head";
	



	Map<String, Configuration> stop() {
		return this.stop;
	}

	private final Map<String, Configuration> stop;

	@SuppressWarnings("unchecked")
	TestCasesSpider() {
		this.stop = new HashMap<String, Configuration>();
		final Map<String, Configuration> peace = new HashMap<String, Configuration>();
		final Map<String, Configuration> fist = new HashMap<String, Configuration>();
		final Map<String, Configuration> shaka = new HashMap<String, Configuration>();
		final Map<String, Configuration> spread = new HashMap<String, Configuration>();
		final Map<String, Configuration> claw = new HashMap<String, Configuration>();

		super.add(stop, peace, fist, shaka, spread, claw);

		// the upper arm, forearm, and hand angles do not change through any of the
		// test cases
		stop.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		fist.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(HEAD_NAME, new BaseConfiguration(0, 0, 0));


		stop.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		peace.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		fist.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		shaka.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		spread.put(BODY_NAME, new BaseConfiguration(0, 0, 0));
		claw.put(BODY_NAME, new BaseConfiguration(0, 0, 0));

		// the stop test case
		stop.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		stop.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		stop.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(0, 0, 0));
		stop.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(0, 0, 0));
		stop.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(0, 0, 0));
		stop.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(0, 30, 30));
		stop.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(30, 0, 0));
		stop.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(20, 0, 0));
		stop.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(0, 30, 30));

		// the peace sign test case
		peace.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(50, 0, 0));
		peace.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(90, 0, 0));
		peace.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(60, 0, 0));
		peace.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(50, 0, 0));
		peace.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(90, 0, 0));
		peace.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(60, 0, 0));
		peace.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		peace.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		peace.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		peace.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		peace.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		peace.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(0, 0, 0));
		peace.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(10, 0, 0));
		peace.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(90, 0, 0));
		peace.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(30, 50, 0));
		peace.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(10, 0, 0));
		peace.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		peace.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(30, 50, 0));

		// the fist test case
		fist.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(50, 0, 0));
		fist.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(90, 0, 0));
		fist.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(60, 0, 0));
		fist.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(50, 0, 0));
		fist.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(90, 0, 0));
		fist.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(60, 0, 0));
		fist.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(50, 0, 0));
		fist.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(90, 0, 0));
		fist.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(60, 0, 0));
		fist.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(50, 0, 0));
		fist.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(90, 0, 0));
		fist.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(60, 0, 0));
		fist.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(50, 0, 0));
		fist.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(60, 0, 0));
		fist.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(30, 50, 0));
		fist.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(50, 50, 0));
		fist.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		fist.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(0, 50, 0));

		// the shaka test case
		shaka.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		shaka.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		shaka.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(0, -10, 0));
		shaka.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(30, 0, 0));
		shaka.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(30, 0, 0));
		shaka.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(35, 0, 0));
		shaka.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(40, 0, 0));
		shaka.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(40, 0, 0));
		shaka.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(55, 0, 0));
		shaka.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(60, 0, 0));
		shaka.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(30, 0, 0));
		shaka.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(25, 0, 0));
		shaka.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(10, 0, 0));
		shaka.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(0, 0, 0));
		shaka.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(0, 60, 0));
		shaka.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(10, 0, 0));
		shaka.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		shaka.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(60, 0, 0));

		// the spread test case
		spread.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		spread.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(0, 10, 0));
		spread.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(0, 10, 0));
		spread.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(0, 10, 0));
		spread.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(0, 0, 0));
		spread.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(0, 10, 0));
		spread.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(0, 0, 0));
		spread.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(0, 60, 0));
		spread.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		spread.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(0, 30, 0));
		spread.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(0, 50, 0));

		// the claw test case
		claw.put(RIGHT_LEG_1_JOINT_1, new BaseConfiguration(60, 0, 0));
		claw.put(RIGHT_LEG_1_JOINT_2, new BaseConfiguration(80, 0, 0));
		claw.put(RIGHT_LEG_1_JOINT_3, new BaseConfiguration(0, 0, 0));
		claw.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(60, 0, 0));
		claw.put(LEFT_LEG_2_JOINT_2, new BaseConfiguration(80, 0, 0));
		claw.put(LEFT_LEG_2_JOINT_1, new BaseConfiguration(0, 0, 0));
		claw.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(60, 0, 0));
		claw.put(LEFT_LEG_3_JOINT_2, new BaseConfiguration(80, 0, 0));
		claw.put(LEFT_LEG_3_JOINT_1, new BaseConfiguration(0, 0, 0));
		claw.put(LEFT_LEG_1_JOINT_1, new BaseConfiguration(60, 0, 0));
		claw.put(LEFT_LEG_1_JOINT_2, new BaseConfiguration(80, 0, 0));
		claw.put(LEFT_LEG_1_JOINT_3, new BaseConfiguration(0, 0, 0));
		claw.put(RIGHT_LEG_2_JOINT_1, new BaseConfiguration(70, 0, 0));
		claw.put(RIGHT_LEG_2_JOINT_2, new BaseConfiguration(20, 0, 0));
		claw.put(RIGHT_LEG_2_JOINT_3, new BaseConfiguration(30, 50, 0));
		claw.put(RIGHT_LEG_3_JOINT_1, new BaseConfiguration(40, 30, 0));
		claw.put(RIGHT_LEG_3_JOINT_2, new BaseConfiguration(0, 0, 0));
		claw.put(RIGHT_LEG_3_JOINT_3, new BaseConfiguration(30, 50, 0));
	}
}
