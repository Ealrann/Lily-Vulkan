/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IDescriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.IDescriptor#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.IDescriptor#getShaderStages <em>Shader Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getIDescriptor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IDescriptor extends EObject
{
	/**
	 * Returns the value of the '<em><b>Descriptor Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EDescriptorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EDescriptorType
	 * @see #setDescriptorType(EDescriptorType)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getIDescriptor_DescriptorType()
	 * @model unique="false"
	 * @generated
	 */
	EDescriptorType getDescriptorType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.IDescriptor#getDescriptorType <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EDescriptorType
	 * @see #getDescriptorType()
	 * @generated
	 */
	void setDescriptorType(EDescriptorType value);

	/**
	 * Returns the value of the '<em><b>Shader Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader Stages</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getIDescriptor_ShaderStages()
	 * @model
	 * @generated
	 */
	EList<EShaderStage> getShaderStages();

} // IDescriptor