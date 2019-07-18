/**
 */
package org.sheepy.lily.vulkan.model.resource;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage <em>Usage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider()
 * @model abstract="true"
 * @generated
 */
public interface BufferDataProvider<T> extends LNamedElement
{
	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see #setUsage(EBufferUsage)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_Usage()
	 * @model unique="false"
	 * @generated
	 */
	EBufferUsage getUsage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(EBufferUsage value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_InstanceCount()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' reference.
	 * @see #setDataSource(Object)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBufferDataProvider_DataSource()
	 * @model kind="reference"
	 * @generated
	 */
	T getDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.BufferDataProvider#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(T value);

} // BufferDataProvider
