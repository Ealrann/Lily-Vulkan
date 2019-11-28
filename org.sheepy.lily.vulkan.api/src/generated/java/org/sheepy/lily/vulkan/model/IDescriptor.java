/**
 */
package org.sheepy.lily.vulkan.model;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDescriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.IDescriptor#getType <em>Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.IDescriptor#getShaderStages <em>Shader Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIDescriptor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDescriptor extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EDescriptorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #setType(EDescriptorType)
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIDescriptor_Type()
	 * @model required="true"
	 * @generated
	 */
	EDescriptorType getType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.IDescriptor#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #getType()
	 * @generated
	 */
	void setType(EDescriptorType value);

	/**
	 * Returns the value of the '<em><b>Shader Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.model.VulkanPackage#getIDescriptor_ShaderStages()
	 * @model required="true"
	 * @generated
	 */
	EList<EShaderStage> getShaderStages();

} // IDescriptor
