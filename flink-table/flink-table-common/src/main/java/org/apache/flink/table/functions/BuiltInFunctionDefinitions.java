/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.table.functions;

import org.apache.flink.annotation.PublicEvolving;
import org.apache.flink.table.api.TableException;
import org.apache.flink.util.Preconditions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.apache.flink.table.functions.FunctionKind.AGGREGATE;
import static org.apache.flink.table.functions.FunctionKind.OTHER;
import static org.apache.flink.table.functions.FunctionKind.SCALAR;

/**
 * Dictionary of function definitions for all built-in functions.
 */
@PublicEvolving
public final class BuiltInFunctionDefinitions {

	// logic functions
	public static final BuiltInFunctionDefinition AND =
		new BuiltInFunctionDefinition.Builder()
			.name("and")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition OR =
		new BuiltInFunctionDefinition.Builder()
			.name("or")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition NOT =
		new BuiltInFunctionDefinition.Builder()
			.name("not")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IF =
		new BuiltInFunctionDefinition.Builder()
			.name("ifThenElse")
			.kind(SCALAR)
			.build();

	// comparison functions
	public static final BuiltInFunctionDefinition EQUALS =
		new BuiltInFunctionDefinition.Builder()
			.name("equals")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition GREATER_THAN =
		new BuiltInFunctionDefinition.Builder()
			.name("greaterThan")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition GREATER_THAN_OR_EQUAL =
		new BuiltInFunctionDefinition.Builder()
			.name("greaterThanOrEqual")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LESS_THAN =
		new BuiltInFunctionDefinition.Builder()
			.name("lessThan")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LESS_THAN_OR_EQUAL =
		new BuiltInFunctionDefinition.Builder()
			.name("lessThanOrEqual")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition NOT_EQUALS =
		new BuiltInFunctionDefinition.Builder()
			.name("notEquals")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_NULL =
		new BuiltInFunctionDefinition.Builder()
			.name("isNull")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_NOT_NULL =
		new BuiltInFunctionDefinition.Builder()
			.name("isNotNull")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_TRUE =
		new BuiltInFunctionDefinition.Builder()
			.name("isTrue")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_FALSE =
		new BuiltInFunctionDefinition.Builder()
			.name("isFalse")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_NOT_TRUE =
		new BuiltInFunctionDefinition.Builder()
			.name("isNotTrue")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition IS_NOT_FALSE =
		new BuiltInFunctionDefinition.Builder()
			.name("isNotFalse")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition BETWEEN =
		new BuiltInFunctionDefinition.Builder()
			.name("between")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition NOT_BETWEEN =
		new BuiltInFunctionDefinition.Builder()
			.name("notBetween")
			.kind(SCALAR)
			.build();

	// aggregate functions
	public static final BuiltInFunctionDefinition AVG =
		new BuiltInFunctionDefinition.Builder()
			.name("avg")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition COUNT =
		new BuiltInFunctionDefinition.Builder()
			.name("count")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition MAX =
		new BuiltInFunctionDefinition.Builder()
			.name("max")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition MIN =
		new BuiltInFunctionDefinition.Builder()
			.name("min")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition SUM =
		new BuiltInFunctionDefinition.Builder()
			.name("sum")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition SUM0 =
		new BuiltInFunctionDefinition.Builder()
			.name("sum0")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition STDDEV_POP =
		new BuiltInFunctionDefinition.Builder()
			.name("stddevPop")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition STDDEV_SAMP =
		new BuiltInFunctionDefinition.Builder()
			.name("stddevSamp")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition VAR_POP =
		new BuiltInFunctionDefinition.Builder()
			.name("varPop")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition VAR_SAMP =
		new BuiltInFunctionDefinition.Builder()
			.name("varSamp")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition COLLECT =
		new BuiltInFunctionDefinition.Builder()
			.name("collect")
			.kind(AGGREGATE)
			.build();
	public static final BuiltInFunctionDefinition DISTINCT =
		new BuiltInFunctionDefinition.Builder()
			.name("distinct")
			.kind(AGGREGATE)
			.build();

	// string functions
	public static final BuiltInFunctionDefinition CHAR_LENGTH =
		new BuiltInFunctionDefinition.Builder()
			.name("charLength")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition INIT_CAP =
		new BuiltInFunctionDefinition.Builder()
			.name("initCap")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LIKE =
		new BuiltInFunctionDefinition.Builder()
			.name("like")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOWER =
		new BuiltInFunctionDefinition.Builder()
			.name("lowerCase")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SIMILAR =
		new BuiltInFunctionDefinition.Builder()
			.name("similar")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SUBSTRING =
		new BuiltInFunctionDefinition.Builder()
			.name("substring")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition REPLACE =
		new BuiltInFunctionDefinition.Builder()
			.name("replace")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TRIM =
		new BuiltInFunctionDefinition.Builder()
			.name("trim")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition UPPER =
		new BuiltInFunctionDefinition.Builder()
			.name("upperCase")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition POSITION =
		new BuiltInFunctionDefinition.Builder()
			.name("position")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition OVERLAY =
		new BuiltInFunctionDefinition.Builder()
			.name("overlay")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CONCAT =
		new BuiltInFunctionDefinition.Builder()
			.name("concat")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CONCAT_WS =
		new BuiltInFunctionDefinition.Builder()
			.name("concat_ws")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LPAD =
		new BuiltInFunctionDefinition.Builder()
			.name("lpad")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition RPAD =
		new BuiltInFunctionDefinition.Builder()
			.name("rpad")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition REGEXP_EXTRACT =
		new BuiltInFunctionDefinition.Builder()
			.name("regexpExtract")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition FROM_BASE64 =
		new BuiltInFunctionDefinition.Builder()
			.name("fromBase64")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TO_BASE64 =
		new BuiltInFunctionDefinition.Builder()
			.name("toBase64")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition UUID =
		new BuiltInFunctionDefinition.Builder()
			.name("uuid")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LTRIM =
		new BuiltInFunctionDefinition.Builder()
			.name("ltrim")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition RTRIM =
		new BuiltInFunctionDefinition.Builder()
			.name("rtrim")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition REPEAT =
		new BuiltInFunctionDefinition.Builder()
			.name("repeat")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition REGEXP_REPLACE =
		new BuiltInFunctionDefinition.Builder()
			.name("regexpReplace")
			.kind(SCALAR)
			.build();

	// math functions
	public static final BuiltInFunctionDefinition PLUS =
		new BuiltInFunctionDefinition.Builder()
			.name("plus")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition MINUS =
		new BuiltInFunctionDefinition.Builder()
			.name("minus")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition DIVIDE =
		new BuiltInFunctionDefinition.Builder()
			.name("divide")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TIMES =
		new BuiltInFunctionDefinition.Builder()
			.name("times")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ABS =
		new BuiltInFunctionDefinition.Builder()
			.name("abs")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CEIL =
		new BuiltInFunctionDefinition.Builder()
			.name("ceil")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition EXP =
		new BuiltInFunctionDefinition.Builder()
			.name("exp")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition FLOOR =
		new BuiltInFunctionDefinition.Builder()
			.name("floor")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOG10 =
		new BuiltInFunctionDefinition.Builder()
			.name("log10")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOG2 =
		new BuiltInFunctionDefinition.Builder()
			.name("log2")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LN =
		new BuiltInFunctionDefinition.Builder()
			.name("ln")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOG =
		new BuiltInFunctionDefinition.Builder()
			.name("log")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition POWER =
		new BuiltInFunctionDefinition.Builder()
			.name("power")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition MOD =
		new BuiltInFunctionDefinition.Builder()
			.name("mod")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SQRT =
		new BuiltInFunctionDefinition.Builder()
			.name("sqrt")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition MINUS_PREFIX =
		new BuiltInFunctionDefinition.Builder()
			.name("minusPrefix")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SIN =
		new BuiltInFunctionDefinition.Builder()
			.name("sin")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition COS =
		new BuiltInFunctionDefinition.Builder()
			.name("cos")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SINH =
		new BuiltInFunctionDefinition.Builder()
			.name("sinh")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TAN =
		new BuiltInFunctionDefinition.Builder()
			.name("tan")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TANH =
		new BuiltInFunctionDefinition.Builder()
			.name("tanh")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition COT =
		new BuiltInFunctionDefinition.Builder()
			.name("cot")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ASIN =
		new BuiltInFunctionDefinition.Builder()
			.name("asin")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ACOS =
		new BuiltInFunctionDefinition.Builder()
			.name("acos")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ATAN =
		new BuiltInFunctionDefinition.Builder()
			.name("atan")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ATAN2 =
		new BuiltInFunctionDefinition.Builder()
			.name("atan2")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition COSH =
		new BuiltInFunctionDefinition.Builder()
			.name("cosh")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition DEGREES =
		new BuiltInFunctionDefinition.Builder()
			.name("degrees")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition RADIANS =
		new BuiltInFunctionDefinition.Builder()
			.name("radians")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SIGN =
		new BuiltInFunctionDefinition.Builder()
			.name("sign")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ROUND =
		new BuiltInFunctionDefinition.Builder()
			.name("round")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition PI =
		new BuiltInFunctionDefinition.Builder()
			.name("pi")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition E =
		new BuiltInFunctionDefinition.Builder()
			.name("e")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition RAND =
		new BuiltInFunctionDefinition.Builder()
			.name("rand")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition RAND_INTEGER =
		new BuiltInFunctionDefinition.Builder()
			.name("randInteger")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition BIN =
		new BuiltInFunctionDefinition.Builder()
			.name("bin")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition HEX =
		new BuiltInFunctionDefinition.Builder()
			.name("hex")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TRUNCATE =
		new BuiltInFunctionDefinition.Builder()
			.name("truncate")
			.kind(SCALAR)
			.build();

	// time functions
	public static final BuiltInFunctionDefinition EXTRACT =
		new BuiltInFunctionDefinition.Builder()
			.name("extract")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CURRENT_DATE =
		new BuiltInFunctionDefinition.Builder()
			.name("currentDate")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CURRENT_TIME =
		new BuiltInFunctionDefinition.Builder()
			.name("currentTime")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CURRENT_TIMESTAMP =
		new BuiltInFunctionDefinition.Builder()
			.name("currentTimestamp")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOCAL_TIME =
		new BuiltInFunctionDefinition.Builder()
			.name("localTime")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition LOCAL_TIMESTAMP =
		new BuiltInFunctionDefinition.Builder()
			.name("localTimestamp")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TEMPORAL_OVERLAPS =
		new BuiltInFunctionDefinition.Builder()
			.name("temporalOverlaps")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition DATE_TIME_PLUS =
		new BuiltInFunctionDefinition.Builder()
			.name("dateTimePlus")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition DATE_FORMAT =
		new BuiltInFunctionDefinition.Builder()
			.name("dateFormat")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition TIMESTAMP_DIFF =
		new BuiltInFunctionDefinition.Builder()
			.name("timestampDiff")
			.kind(SCALAR)
			.build();

	// collection
	public static final BuiltInFunctionDefinition AT =
		new BuiltInFunctionDefinition.Builder()
			.name("at")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CARDINALITY =
		new BuiltInFunctionDefinition.Builder()
			.name("cardinality")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ARRAY =
		new BuiltInFunctionDefinition.Builder()
			.name("array")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ARRAY_ELEMENT =
		new BuiltInFunctionDefinition.Builder()
			.name("element")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition MAP =
		new BuiltInFunctionDefinition.Builder()
			.name("map")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition ROW =
		new BuiltInFunctionDefinition.Builder()
			.name("row")
			.kind(SCALAR)
			.build();

	// composite
	public static final BuiltInFunctionDefinition FLATTEN =
		new BuiltInFunctionDefinition.Builder()
			.name("flatten")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition GET =
		new BuiltInFunctionDefinition.Builder()
			.name("get")
			.kind(OTHER)
			.build();

	// window properties
	public static final BuiltInFunctionDefinition WINDOW_START =
		new BuiltInFunctionDefinition.Builder()
			.name("start")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition WINDOW_END =
		new BuiltInFunctionDefinition.Builder()
			.name("end")
			.kind(OTHER)
			.build();

	// ordering
	public static final BuiltInFunctionDefinition ORDER_ASC =
		new BuiltInFunctionDefinition.Builder()
			.name("asc")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition ORDER_DESC =
		new BuiltInFunctionDefinition.Builder()
			.name("desc")
			.kind(OTHER)
			.build();

	// crypto hash
	public static final BuiltInFunctionDefinition MD5 =
		new BuiltInFunctionDefinition.Builder()
			.name("md5")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA1 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha1")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA224 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha224")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA256 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha256")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA384 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha384")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA512 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha512")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition SHA2 =
		new BuiltInFunctionDefinition.Builder()
			.name("sha2")
			.kind(SCALAR)
			.build();

	// time attributes
	public static final BuiltInFunctionDefinition PROCTIME =
		new BuiltInFunctionDefinition.Builder()
			.name("proctime")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition ROWTIME =
		new BuiltInFunctionDefinition.Builder()
			.name("rowtime")
			.kind(OTHER)
			.build();

	// over window
	public static final BuiltInFunctionDefinition OVER =
		new BuiltInFunctionDefinition.Builder()
			.name("over")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition UNBOUNDED_RANGE =
		new BuiltInFunctionDefinition.Builder()
			.name("unboundedRange")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition UNBOUNDED_ROW =
		new BuiltInFunctionDefinition.Builder()
			.name("unboundedRow")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition CURRENT_RANGE =
		new BuiltInFunctionDefinition.Builder()
			.name("currentRange")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition CURRENT_ROW =
		new BuiltInFunctionDefinition.Builder()
			.name("currentRow")
			.kind(OTHER)
			.build();

	// columns
	public static final BuiltInFunctionDefinition WITH_COLUMNS =
		new BuiltInFunctionDefinition.Builder()
			.name("withColumns")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition WITHOUT_COLUMNS =
		new BuiltInFunctionDefinition.Builder()
			.name("withoutColumns")
			.kind(OTHER)
			.build();

	// etc
	public static final BuiltInFunctionDefinition IN =
		new BuiltInFunctionDefinition.Builder()
			.name("in")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition CAST =
		new BuiltInFunctionDefinition.Builder()
			.name("cast")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition REINTERPRET_CAST =
			new BuiltInFunctionDefinition.Builder()
			.name("reinterpretCast")
			.kind(SCALAR)
			.build();
	public static final BuiltInFunctionDefinition AS =
		new BuiltInFunctionDefinition.Builder()
			.name("as")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition STREAM_RECORD_TIMESTAMP =
		new BuiltInFunctionDefinition.Builder()
			.name("streamRecordTimestamp")
			.kind(OTHER)
			.build();
	public static final BuiltInFunctionDefinition RANGE_TO =
		new BuiltInFunctionDefinition.Builder()
			.name("rangeTo")
			.kind(OTHER)
			.build();

	public static final Set<FunctionDefinition> WINDOW_PROPERTIES = new HashSet<>(Arrays.asList(
		WINDOW_START, WINDOW_END, PROCTIME, ROWTIME
	));

	public static final Set<FunctionDefinition> TIME_ATTRIBUTES = new HashSet<>(Arrays.asList(
		PROCTIME, ROWTIME
	));

	public static final List<FunctionDefinition> ORDERING = Arrays.asList(ORDER_ASC, ORDER_DESC);

	public static List<BuiltInFunctionDefinition> getDefinitions() {
		final Field[] fields = BuiltInFunctionDefinitions.class.getFields();
		final List<BuiltInFunctionDefinition> list = new ArrayList<>(fields.length);
		for (Field field : fields) {
			if (FunctionDefinition.class.isAssignableFrom(field.getType())) {
				try {
					final BuiltInFunctionDefinition funcDef = (BuiltInFunctionDefinition) field.get(BuiltInFunctionDefinitions.class);
					list.add(Preconditions.checkNotNull(funcDef));
				} catch (IllegalAccessException e) {
					throw new TableException(
						"The function definition for field " + field.getName() + " is not accessible.", e);
				}
			}
		}
		return list;
	}
}
