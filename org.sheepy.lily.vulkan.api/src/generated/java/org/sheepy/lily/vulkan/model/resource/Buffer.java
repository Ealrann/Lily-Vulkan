/**
 */
package org.sheepy.lily.vulkan.model.resource;

import java.nio.ByteBuffer;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.model.resource.IResource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EInstanceCount;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getData <em>Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#isKeptMapped <em>Kept Mapped</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#isHostVisible <em>Host Visible</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#isCoherent <em>Coherent</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer()
 * @model
 * @generated
 */
public interface Buffer extends IBuffer, IResource
{
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_Data()
	 * @model unique="false" dataType="org.sheepy.lily.vulkan.model.resource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getData();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(ByteBuffer value);

	/**
	 * Returns the value of the '<em><b>Kept Mapped</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kept Mapped</em>' attribute.
	 * @see #setKeptMapped(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_KeptMapped()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isKeptMapped();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isKeptMapped <em>Kept Mapped</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kept Mapped</em>' attribute.
	 * @see #isKeptMapped()
	 * @generated
	 */
	void setKeptMapped(boolean value);

	/**
	 * Returns the value of the '<em><b>Host Visible</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host Visible</em>' attribute.
	 * @see #setHostVisible(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_HostVisible()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isHostVisible();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isHostVisible <em>Host Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host Visible</em>' attribute.
	 * @see #isHostVisible()
	 * @generated
	 */
	void setHostVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Coherent</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coherent</em>' attribute.
	 * @see #setCoherent(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_Coherent()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isCoherent();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isCoherent <em>Coherent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coherent</em>' attribute.
	 * @see #isCoherent()
	 * @generated
	 */
	void setCoherent(boolean value);

	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_Usages()
	 * @model
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EInstanceCount}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #setInstanceCount(EInstanceCount)
	 * @see org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage#getBuffer_InstanceCount()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EInstanceCount getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EInstanceCount
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(EInstanceCount value);

} // Buffer
