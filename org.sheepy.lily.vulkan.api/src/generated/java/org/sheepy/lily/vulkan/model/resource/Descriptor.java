/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Descriptor#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Descriptor#getShaderStages <em>Shader Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getDescriptor()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Descriptor extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Descriptor Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EDescriptorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #setDescriptorType(EDescriptorType)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getDescriptor_DescriptorType()
	 * @model unique="false"
	 * @generated
	 */
	EDescriptorType getDescriptorType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Descriptor#getDescriptorType <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #getDescriptorType()
	 * @generated
	 */
	void setDescriptorType(EDescriptorType value);

	/**
	 * Returns the value of the '<em><b>Shader Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shader Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getDescriptor_ShaderStages()
	 * @model
	 * @generated
	 */
	EList<EShaderStage> getShaderStages();

} // Descriptor
