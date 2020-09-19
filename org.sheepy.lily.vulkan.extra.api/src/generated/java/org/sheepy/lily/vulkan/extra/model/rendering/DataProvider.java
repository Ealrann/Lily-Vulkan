/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering;

import org.eclipse.emf.common.util.EList;

import org.sheepy.lily.core.api.model.ILilyEObject;

import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getUsages <em>Usages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getGrowFactor <em>Grow Factor</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getMinSize <em>Min Size</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getDataSource <em>Data Source</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getBufferName <em>Buffer Name</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface DataProvider<T extends Structure> extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Usages</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EBufferUsage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usages</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EBufferUsage
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider_Usages()
	 * @model required="true"
	 * @generated
	 */
	EList<EBufferUsage> getUsages();

	/**
	 * Returns the value of the '<em><b>Grow Factor</b></em>' attribute.
	 * The default value is <code>"1.5f"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Grow Factor</em>' attribute.
	 * @see #setGrowFactor(float)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider_GrowFactor()
	 * @model default="1.5f" required="true"
	 * @generated
	 */
	float getGrowFactor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getGrowFactor <em>Grow Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Grow Factor</em>' attribute.
	 * @see #getGrowFactor()
	 * @generated
	 */
	void setGrowFactor(float value);

	/**
	 * Returns the value of the '<em><b>Min Size</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Size</em>' attribute.
	 * @see #setMinSize(long)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider_MinSize()
	 * @model default="0"
	 * @generated
	 */
	long getMinSize();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getMinSize <em>Min Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Size</em>' attribute.
	 * @see #getMinSize()
	 * @generated
	 */
	void setMinSize(long value);

	/**
	 * Returns the value of the '<em><b>Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Source</em>' reference.
	 * @see #setDataSource(IBufferDataSource)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider_DataSource()
	 * @model
	 * @generated
	 */
	IBufferDataSource getDataSource();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getDataSource <em>Data Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Source</em>' reference.
	 * @see #getDataSource()
	 * @generated
	 */
	void setDataSource(IBufferDataSource value);

	/**
	 * Returns the value of the '<em><b>Buffer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffer Name</em>' attribute.
	 * @see #setBufferName(String)
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage#getDataProvider_BufferName()
	 * @model required="true"
	 * @generated
	 */
	String getBufferName();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider#getBufferName <em>Buffer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffer Name</em>' attribute.
	 * @see #getBufferName()
	 * @generated
	 */
	void setBufferName(String value);

} // DataProvider
