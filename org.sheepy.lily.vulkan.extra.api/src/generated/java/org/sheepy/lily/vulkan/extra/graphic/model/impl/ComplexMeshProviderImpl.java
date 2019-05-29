/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.extra.graphic.model.ComplexMeshProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage;
import org.sheepy.lily.vulkan.extra.graphic.model.IndexDataProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.UniformDataProvider;
import org.sheepy.lily.vulkan.extra.graphic.model.VertexDataProvider;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Mesh Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl#getVertexDataProvider <em>Vertex Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl#getIndexDataProvider <em>Index Data Provider</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.impl.ComplexMeshProviderImpl#getUniformDataProvider <em>Uniform Data Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexMeshProviderImpl extends MeshProviderImpl implements ComplexMeshProvider
{
	/**
	 * The cached value of the '{@link #getVertexDataProvider() <em>Vertex Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexDataProvider()
	 * @generated
	 * @ordered
	 */
	protected VertexDataProvider vertexDataProvider;

	/**
	 * The cached value of the '{@link #getIndexDataProvider() <em>Index Data Provider</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexDataProvider()
	 * @generated
	 * @ordered
	 */
	protected IndexDataProvider indexDataProvider;

	/**
	 * The cached value of the '{@link #getUniformDataProvider() <em>Uniform Data Provider</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniformDataProvider()
	 * @generated
	 * @ordered
	 */
	protected EList<UniformDataProvider> uniformDataProvider;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexMeshProviderImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicExtraPackage.Literals.COMPLEX_MESH_PROVIDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexDataProvider getVertexDataProvider()
	{
		return vertexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVertexDataProvider(VertexDataProvider newVertexDataProvider, NotificationChain msgs)
	{
		VertexDataProvider oldVertexDataProvider = vertexDataProvider;
		vertexDataProvider = newVertexDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER, oldVertexDataProvider, newVertexDataProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexDataProvider(VertexDataProvider newVertexDataProvider)
	{
		if (newVertexDataProvider != vertexDataProvider)
		{
			NotificationChain msgs = null;
			if (vertexDataProvider != null)
				msgs = ((InternalEObject)vertexDataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER, null, msgs);
			if (newVertexDataProvider != null)
				msgs = ((InternalEObject)newVertexDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER, null, msgs);
			msgs = basicSetVertexDataProvider(newVertexDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER, newVertexDataProvider, newVertexDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndexDataProvider getIndexDataProvider()
	{
		return indexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIndexDataProvider(IndexDataProvider newIndexDataProvider, NotificationChain msgs)
	{
		IndexDataProvider oldIndexDataProvider = indexDataProvider;
		indexDataProvider = newIndexDataProvider;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER, oldIndexDataProvider, newIndexDataProvider);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexDataProvider(IndexDataProvider newIndexDataProvider)
	{
		if (newIndexDataProvider != indexDataProvider)
		{
			NotificationChain msgs = null;
			if (indexDataProvider != null)
				msgs = ((InternalEObject)indexDataProvider).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER, null, msgs);
			if (newIndexDataProvider != null)
				msgs = ((InternalEObject)newIndexDataProvider).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER, null, msgs);
			msgs = basicSetIndexDataProvider(newIndexDataProvider, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER, newIndexDataProvider, newIndexDataProvider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UniformDataProvider> getUniformDataProvider()
	{
		if (uniformDataProvider == null)
		{
			uniformDataProvider = new EObjectContainmentEList<UniformDataProvider>(UniformDataProvider.class, this, GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER);
		}
		return uniformDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER:
				return basicSetVertexDataProvider(null, msgs);
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER:
				return basicSetIndexDataProvider(null, msgs);
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER:
				return ((InternalEList<?>)getUniformDataProvider()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER:
				return getVertexDataProvider();
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER:
				return getIndexDataProvider();
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER:
				return getUniformDataProvider();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER:
				setVertexDataProvider((VertexDataProvider)newValue);
				return;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER:
				setIndexDataProvider((IndexDataProvider)newValue);
				return;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER:
				getUniformDataProvider().clear();
				getUniformDataProvider().addAll((Collection<? extends UniformDataProvider>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER:
				setVertexDataProvider((VertexDataProvider)null);
				return;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER:
				setIndexDataProvider((IndexDataProvider)null);
				return;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER:
				getUniformDataProvider().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__VERTEX_DATA_PROVIDER:
				return vertexDataProvider != null;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__INDEX_DATA_PROVIDER:
				return indexDataProvider != null;
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER__UNIFORM_DATA_PROVIDER:
				return uniformDataProvider != null && !uniformDataProvider.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexMeshProviderImpl
