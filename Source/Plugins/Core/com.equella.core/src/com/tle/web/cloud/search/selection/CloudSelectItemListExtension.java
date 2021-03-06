/*
 * Copyright 2017 Apereo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tle.web.cloud.search.selection;

import com.tle.core.cloud.CloudConstants;
import com.tle.core.cloud.beans.converted.CloudItem;
import com.tle.core.guice.Bind;
import com.tle.web.cloud.search.CloudSearchListEntry;
import com.tle.web.cloud.view.CloudViewableItem;
import com.tle.web.search.selection.AbstractSelectItemListExtension;
import com.tle.web.sections.SectionInfo;
import com.tle.web.viewable.ViewableItem;

/**
 * @author Aaron
 */
@Bind
public class CloudSelectItemListExtension extends AbstractSelectItemListExtension<CloudItem, CloudSearchListEntry>
{
	@Override
	protected ViewableItem<CloudItem> getViewableItem(SectionInfo info, CloudItem item)
	{
		return new CloudViewableItem(item);
	}

	@Override
	public String getItemExtensionType()
	{
		return CloudConstants.ITEM_EXTENSION;
	}
}
