/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Constants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.AbstractConstants#getStages <em>Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getAbstractConstants()
 * @model abstract="true"
 * @generated
 */
public interface AbstractConstants extends BasicResource
{
	/**
	 * Returns the value of the '<em><b>Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getAbstractConstants_Stages()
	 * @model
	 * @generated
	 */
	EList<EShaderStage> getStages();

} // AbstractConstants
