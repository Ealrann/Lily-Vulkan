/**
 */
package org.sheepy.vulkan.model.resource;

import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Constants</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.AbstractConstants#getStage <em>Stage</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getAbstractConstants()
 * @model abstract="true"
 * @generated
 */
public interface AbstractConstants extends BasicResource
{
	/**
	 * Returns the value of the '<em><b>Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see #setStage(EShaderStage)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getAbstractConstants_Stage()
	 * @model unique="false"
	 * @generated
	 */
	EShaderStage getStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.AbstractConstants#getStage <em>Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see #getStage()
	 * @generated
	 */
	void setStage(EShaderStage value);

} // AbstractConstants
