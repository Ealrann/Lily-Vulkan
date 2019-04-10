/**
 */
package org.sheepy.lily.vulkan.model.resource;

import java.nio.ByteBuffer;
import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.enumeration.EBufferUsage;

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
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getData <em>Data</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#isOftenUpdated <em>Often Updated</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#isGpuBuffer <em>Gpu Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount <em>Instance Count</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer()
 * @model
 * @generated
 */
public interface Buffer extends DescriptorResource
{
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(long)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_Size()
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
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.lily.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usages</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.lily.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_Usages()
	 * @model
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(ByteBuffer)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_Data()
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
	 * Returns the value of the '<em><b>Often Updated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Often Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Often Updated</em>' attribute.
	 * @see #setOftenUpdated(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_OftenUpdated()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isOftenUpdated();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isOftenUpdated <em>Often Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Often Updated</em>' attribute.
	 * @see #isOftenUpdated()
	 * @generated
	 */
	void setOftenUpdated(boolean value);

	/**
	 * Returns the value of the '<em><b>Gpu Buffer</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gpu Buffer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gpu Buffer</em>' attribute.
	 * @see #setGpuBuffer(boolean)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_GpuBuffer()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isGpuBuffer();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#isGpuBuffer <em>Gpu Buffer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gpu Buffer</em>' attribute.
	 * @see #isGpuBuffer()
	 * @generated
	 */
	void setGpuBuffer(boolean value);

	/**
	 * Returns the value of the '<em><b>Instance Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Count</em>' attribute.
	 * @see #setInstanceCount(int)
	 * @see org.sheepy.lily.vulkan.model.resource.ResourcePackage#getBuffer_InstanceCount()
	 * @model default="1" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel propertyDescription='Every push in this buffer will write on the next instance, and update the descriptor acordingly'"
	 * @generated
	 */
	int getInstanceCount();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.resource.Buffer#getInstanceCount <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Count</em>' attribute.
	 * @see #getInstanceCount()
	 * @generated
	 */
	void setInstanceCount(int value);

} // Buffer
