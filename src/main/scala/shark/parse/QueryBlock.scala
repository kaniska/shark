/*
 * Copyright (C) 2012 The Regents of The University California.
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package shark.parse

import org.apache.hadoop.hive.ql.parse.{QB => HiveQueryBlock}

import shark.memstore2.CacheType
import shark.memstore2.CacheType._


/**
 * A container for flags and table metadata. Used in SharkSemanticAnalyzer while parsing
 * and analyzing ASTs (e.g. in SharkSemanticAnalyzer#analyzeCreateTable()).
 */
class QueryBlock(outerID: String, alias: String, isSubQuery: Boolean)
    extends HiveQueryBlock(outerID, alias, isSubQuery) {

  // The CacheType for the table that will be created from CREATE TABLE/CTAS.
  private var cacheModeForCreateTable = CacheType.NONE

  def setCacheModeForCreateTable(cacheModeToSet: CacheType) {
    cacheModeForCreateTable = cacheModeToSet
  }

  def getCacheModeForCreateTable(): CacheType = cacheModeForCreateTable
}
