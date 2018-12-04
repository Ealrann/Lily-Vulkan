/**
 */
package org.sheepy.vulkan.model.resource;

import java.nio.ByteBuffer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.resource.Buffer#getSize <em>Size</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Buffer#getUsage <em>Usage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Buffer#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Buffer#isChangeable <em>Changeable</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.resource.Buffer#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer()
 * @model
 * @generated
 */
public interface Buffer extends PipelineResource
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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer_Size()
	 * @model unique="false"
	 * @generated
	 */
	long getSize();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Buffer#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(long value);

	/**
	 * Returns the value of the '<em><b>Usage</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage</em>' attribute.
	 * @see #setUsage(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer_Usage()
	 * @model unique="false"
	 * @generated
	 */
	int getUsage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Buffer#getUsage <em>Usage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage</em>' attribute.
	 * @see #getUsage()
	 * @generated
	 */
	void setUsage(int value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(int)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer_Properties()
	 * @model unique="false"
	 * @generated
	 */
	int getProperties();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Buffer#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(int value);

	/**
	 * Returns the value of the '<em><b>Changeable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Changeable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changeable</em>' attribute.
	 * @see #setChangeable(boolean)
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer_Changeable()
	 * @model default="false" unique="false"
	 * @generated
	 */
	boolean isChangeable();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Buffer#isChangeable <em>Changeable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Changeable</em>' attribute.
	 * @see #isChangeable()
	 * @generated
	 */
	void setChangeable(boolean value);

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
	 * @see org.sheepy.vulkan.model.resource.ResourcePackage#getBuffer_Data()
	 * @model unique="false" dataType="org.sheepy.vulkan.model.resource.ByteBuffer"
	 * @generated
	 */
	ByteBuffer getData();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.resource.Buffer#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(ByteBuffer value);

} // Buffer
