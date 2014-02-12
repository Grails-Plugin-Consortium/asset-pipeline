/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package asset.pipeline

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * @author David Estes
 */
class ManifestAssetFileSpec extends Specification {
	
    void "should not ever return a directive pattern"() {
     	when:
     		def manifestFile = new ManifestAssetFile()
 		then:
 			directive == manifestFile.directiveForLine(line)?.trim()
 		where: 
	 		line 				 | directive
	 		'//=require_self'	 | null
	 		'//= require_self'   | null
	 		'//= require jquery' | null
	 		'Blank Section'      | null
	 		'//= require_tree .' | null
    }



}
