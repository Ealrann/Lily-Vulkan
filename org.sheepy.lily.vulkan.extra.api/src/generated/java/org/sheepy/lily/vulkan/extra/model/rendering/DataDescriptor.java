/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getPart <em>Part</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getDescriptorType <em>Descriptor Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getStages <em>Stages</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptor()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface DataDescriptor extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' attribute.
	 * @see #setPart(int)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptor_Part()
	 * @model required="true"
	 * @generated
	 */
	int getPart();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getPart <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' attribute.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(int value);

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' attribute.
	 * @see #setInstance(int)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptor_Instance()
	 * @model required="true"
	 * @generated
	 */
	int getInstance();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getInstance <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' attribute.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(int value);

	/**
	 * Returns the value of the '<em><b>Descriptor Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EDescriptorType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #setDescriptorType(EDescriptorType)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptor_DescriptorType()
	 * @model required="true"
	 * @generated
	 */
	EDescriptorType getDescriptorType();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor#getDescriptorType <em>Descriptor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor Type</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EDescriptorType
	 * @see #getDescriptorType()
	 * @generated
	 */
	void setDescriptorType(EDescriptorType value);

	/**
	 * Returns the value of the '<em><b>Stages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EShaderStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EShaderStage
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataDescriptor_Stages()
	 * @model required="true"
	 * @generated
	 */
	EList<EShaderStage> getStages();

} // DataDescriptor
